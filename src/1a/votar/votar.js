"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
var emojis = document.getElementsByClassName("feed");
var urlParams = new URLSearchParams(window.location.search);
var tablegameName = urlParams.get("tablegame");
var tablegame = document.getElementById("tablegame");
tablegame.setAttribute("src", "../resources/logo/".concat(tablegameName, ".png"));
function foreachEmoji(fn) {
    for (var _i = 0, emojis_1 = emojis; _i < emojis_1.length; _i++) {
        var emoji = emojis_1[_i];
        fn(emoji);
    }
}
foreachEmoji(function (emoji) {
    stopEmojiAnimation(emoji);
});
foreachEmoji(function (emoji) {
    emoji.addEventListener("mouseenter", function () {
        if (latestSelectedEmoji == emoji)
            return;
        startEmojiAnimation(emoji);
    });
    emoji.addEventListener("mouseleave", function () {
        if (latestSelectedEmoji == emoji)
            return;
        stopEmojiAnimation(emoji);
    });
});
var emojiRadios = document.getElementsByClassName("feed-button");
var selectedFeedback;
var latestSelectedEmoji;
var _loop_1 = function (radio) {
    radio.addEventListener("change", function () {
        var _a;
        selectedFeedback = +((_a = radio.getAttribute("value")) === null || _a === void 0 ? void 0 : _a.toString());
        var label = document.querySelector("label[for=\"".concat(radio.id, "\"]"));
        var emoji = label === null || label === void 0 ? void 0 : label.getElementsByTagName("img")[0];
        startEmojiAnimation(emoji);
        if (latestSelectedEmoji == undefined) {
            latestSelectedEmoji = emoji;
        }
        else {
            stopEmojiAnimation(latestSelectedEmoji);
        }
        latestSelectedEmoji = emoji;
        var submitButton = document.getElementById("submit");
        submitButton
            .setAttribute("style", "background-color:#000");
        submitButton.removeAttribute("disabled");
        submitButton.addEventListener("click", sendVoteRequest);
    });
};
for (var _i = 0, emojiRadios_1 = emojiRadios; _i < emojiRadios_1.length; _i++) {
    var radio = emojiRadios_1[_i];
    _loop_1(radio);
}
function sendVoteRequest() {
    return __awaiter(this, void 0, void 0, function () {
        var url, feedback, response;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    url = "https://af29-2804-14d-8487-8cb6-24e8-9aaf-911b-d345.ngrok-free.app/vote";
                    feedback = {
                        tablegame: tablegameName,
                        feedback: selectedFeedback,
                        voteClass: "ds1"
                    };
                    return [4 /*yield*/, fetch(url, {
                            method: 'POST',
                            body: JSON.stringify(feedback),
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': '*/*',
                            }
                        }).then(function (response) {
                            if (!response.ok) {
                                alert("algo deu errado no request!");
                            }
                            else {
                                alert("Voto enviado com sucesso!");
                                window.location.href = "/";
                            }
                        })];
                case 1:
                    response = _a.sent();
                    return [2 /*return*/];
            }
        });
    });
}
function startEmojiAnimation(emoji) {
    var currentEmojiSrc = emoji.getAttribute("src");
    emoji.setAttribute("src", currentEmojiSrc.replace(".png", ".gif"));
}
function stopEmojiAnimation(emoji) {
    var currentEmojiSrc = emoji.getAttribute("src");
    emoji.setAttribute("src", currentEmojiSrc.replace(".gif", ".png"));
}
