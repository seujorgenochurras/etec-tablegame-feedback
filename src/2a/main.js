var logoFolder = 'resources/logo/';
var tablegamesDiv = document.getElementById("tablegames");
fetch(logoFolder) // Assuming logoFolder is a valid URL
    .then(function (response) { return response.text(); })
    .then(function (data) {
    var parser = new DOMParser();
    var htmlDoc = parser.parseFromString(data, 'text/html');
    var links = htmlDoc.querySelectorAll('a');
    links.forEach(function (link) {
        var file = link.getAttribute('href');
        if (file.endsWith('.jpg') || file.endsWith('.png')) {
            file = file.replace("src/1a//", "");
            var logoDiv = document.createElement("div");
            logoDiv.setAttribute("class", "tablegame-div");
            var logoHypertext = document.createElement("a");
            logoHypertext.setAttribute("href", "".concat(file.replace("1a/resources/logo/", "votar/")));
            console.log(file);
            var logoImageElement = document.createElement("img");
            logoImageElement.setAttribute("class", "tablegame-img");
            logoImageElement.setAttribute("src", "".concat(file));
            logoHypertext.appendChild(logoImageElement);
            logoDiv.appendChild(logoHypertext);
            tablegamesDiv.appendChild(logoDiv);
        }
    });
})
    .catch(function (error) {
    console.error(error);
});
// fs.readdir(logoFolder, (_err, files) => {
//     files.forEach(file => {
//         const logoDiv = document.createElement("div");
//         logoDiv.setAttribute("class", "tablegame-div");
//         const logoImageElement = document.createElement("img")
//         logoImageElement.setAttribute("class", "tablegame-div");
//         logoImageElement.setAttribute("src", file)
//         console.log(file);
//         logoDiv.appendChild(logoImageElement);
//         tablegamesDiv?.appendChild(logoDiv);
//     })
// })
