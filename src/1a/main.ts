
const logoFolder = 'https://seujorgenochurras.github.io/etec-tablegame-feedback/src/1a/resources/logo';



const tablegamesDiv = document.getElementById("tablegames")!



fetch(logoFolder) // Assuming logoFolder is a valid URL
    .then(response => response.text())
    .then(data => {
        const parser = new DOMParser();
        const htmlDoc = parser.parseFromString(data, 'text/html');
        const links = htmlDoc.querySelectorAll('a');

        links.forEach(link => {
            let file = link.getAttribute('href')!;

            if (file.endsWith('.jpg') || file.endsWith('.png')) {
                file = file.replace("src/1a//", "");

                const logoDiv = document.createElement("div");
                logoDiv.setAttribute("class", "tablegame-div");

                const logoHypertext = document.createElement("a");
                logoHypertext.setAttribute("href", `votar/index.html?tablegame=${file.replace("/src/1a/resources/logo/", "")
                    .replace(".png", "")}`)
                console.log(`votar/index.html?tablegame=${file.replace("/src/1a/resources/logo/", "")
                    .replace(".png", "")}`)

                const logoImageElement = document.createElement("img");
                logoImageElement.setAttribute("class", "tablegame-img");
                logoImageElement.setAttribute("src", `${file}`);

                logoHypertext.appendChild(logoImageElement);
                logoDiv.appendChild(logoHypertext);

                tablegamesDiv.appendChild(logoDiv);
            }
        });
    })
    .catch(error => {
        console.error(error);
    });
