var tablegamesDiv = document.getElementById("tablegames");
var files = ["1Ba_Enzo.png",
    "1Ba_Felipe.png",
    "ArquipelagoAnwaki.png",
    "AstrEspcial.png",
    "Aventura_no_Reino_dos_Numeros.png",
    "Bloqueios.png",
    "Calcule_ou_Drible.png",
    "ColdWar.png",
    "Damistyca.png",
    "DataWar.png",
    "Eureka.png",
    "Exploradores_da_Estatistica.png",
    "Gunhild.png",
    "LM.png",
    "LudoCraft.png",
    "LudoMatematico.png",
    "Matemagico.png",
    "MateMaster.png",
    "OXdaQuestao.png",
    "SSQ.png",
    "StaticRPG.png"];
for (var _i = 0, files_1 = files; _i < files_1.length; _i++) {
    var file = files_1[_i];
    var logoDiv = document.createElement("div");
    logoDiv.setAttribute("class", "tablegame-div");
    var logoHypertext = document.createElement("a");
    logoHypertext.setAttribute("href", "votar/index.html?tablegame=".concat(file.replace("/src/1a/resources/logo/", "")
        .replace(".png", "")));
    var logoImageElement = document.createElement("img");
    logoImageElement.setAttribute("class", "tablegame-img");
    logoImageElement.setAttribute("src", "resources/logo/".concat(file));
    logoHypertext.appendChild(logoImageElement);
    logoDiv.appendChild(logoHypertext);
    tablegamesDiv.appendChild(logoDiv);
}
