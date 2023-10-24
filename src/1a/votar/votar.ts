
export { }


type HtmlElementArrowFunction = (a: Element) => void;

const emojis = document.getElementsByClassName("feed")

const urlParams = new URLSearchParams(window.location.search)!;

const tablegameName = urlParams.get("tablegame")!;


const tablegame = document.getElementById("tablegame")!;

tablegame.setAttribute("src", `../resources/logo/${tablegameName}.png`);


function foreachEmoji(fn: HtmlElementArrowFunction) {
    for (const emoji of emojis) {
        fn(emoji)
    }
}

foreachEmoji((emoji) => {
    stopEmojiAnimation(emoji)
})
foreachEmoji((emoji) => {
    emoji.addEventListener("mouseenter", () => {
        if (latestSelectedEmoji == emoji) return;
        startEmojiAnimation(emoji);
    });
    emoji.addEventListener("mouseleave", () => {
        if (latestSelectedEmoji == emoji) return;
        stopEmojiAnimation(emoji);
    })
})

const emojiRadios = document.getElementsByClassName("feed-button")
let selectedFeedback: Number;
let latestSelectedEmoji: HTMLElement;
for (const radio of emojiRadios) {
    radio.addEventListener("change", () => {
        selectedFeedback = +radio.getAttribute("value")?.toString()!;
        const label = document.querySelector(`label[for="${radio.id}"]`);
        const emoji = label?.getElementsByTagName("img")[0]!;

        startEmojiAnimation(emoji);

        if (latestSelectedEmoji == undefined) {
            latestSelectedEmoji = emoji;
        } else {
            stopEmojiAnimation(latestSelectedEmoji);
        }
        latestSelectedEmoji = emoji;

        const submitButton = document.getElementById("submit")!;
        submitButton
            .setAttribute("style", "background-color:#000");
        submitButton.removeAttribute("disabled")
        submitButton.addEventListener("click", sendVoteRequest);
    });
}

async function sendVoteRequest() {
    const url = "https://af29-2804-14d-8487-8cb6-24e8-9aaf-911b-d345.ngrok-free.app/vote"

    const feedback = {
        tablegame: tablegameName,
        feedback: selectedFeedback,
        voteClass: "ds1"
    }
    const response = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(feedback),
        headers: {
            'Content-Type': 'application/json',
            'Accept': '*/*',
        }

    }).then(response => {
        if (!response.ok) { alert("algo deu errado no request!") }
        else {
            alert("Voto enviado com sucesso!")
            window.location.href = "/"
        }
    }
    );


}
function startEmojiAnimation(emoji: Element) {
    const currentEmojiSrc = emoji.getAttribute("src")!;
    emoji.setAttribute("src", currentEmojiSrc.replace(".png", ".gif"))
}
function stopEmojiAnimation(emoji: Element) {
    const currentEmojiSrc = emoji.getAttribute("src")!;
    emoji.setAttribute("src", currentEmojiSrc.replace(".gif", ".png"))
}
