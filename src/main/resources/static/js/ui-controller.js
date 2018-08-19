import { TYPE } from './tests/data.js';

const BUTTONS_PER_ROW = 4;

function renderCardSets(cardSets) {
    let cardSetsNode = document.querySelector(".cardSets");
    let rows = Math.ceil(cardSets.length / BUTTONS_PER_ROW);
    let rowElements = [];

    for (let i = 0; i < rows; i++) {
        let section = document.createElement("section");

        section.classList.add("row");

        rowElements.push(section)
    }

    rowElements.forEach((row, rowNumber) => {
        row.classList.add(`button-row-${rowNumber}`);
        cardSetsNode.appendChild(row)
    });

    cardSets.forEach((cardSet, index) => {
        let rowNumber = Math.floor(index / BUTTONS_PER_ROW);
        let row = document.querySelector(`.button-row-${rowNumber}`);

        let button = document.createElement("button");
        button.classList.add("btn-sm", "btn-dark");
        button.setAttribute("type", "button");
        button.innerText = cardSet;

        row.appendChild(button)
    });

    return cardSetsNode.innerHTML
}

function renderScheme(scheme) {
    let img = document.createElement("img");

    img.setAttribute("src", "../img/legendary-nick-fury.png");
    img.classList.add("card-image");

    document.querySelector(".scheme-container").appendChild(img);

    document.querySelector(".scheme").textContent = scheme.name
}

function renderMastermind(mastermind) {
    let img = document.createElement("img");

    img.setAttribute("src", "../img/legendary-iron-man.png");
    img.classList.add("card-image");

    document.querySelector(".mastermind-container").appendChild(img);

    document.querySelector(".mastermind").textContent = mastermind.name
}

function renderSingle(data) {
    let containerSelector = "", nameSelector = "";
    let img = document.createElement("img");

    img.setAttribute("src", data.imageURL);
    img.classList.add("card-image");

    if (data.type === TYPE.SCHEME) {
        containerSelector = ".scheme-container";
        nameSelector = ".scheme";
    } else if (data.type === TYPE.MASTERMIND) {
        containerSelector = ".mastermind-container";
        nameSelector = ".mastermind";
    }

    document.querySelector(containerSelector).appendChild(img);
    document.querySelector(nameSelector).textContent = data.name;
}

function renderVillains(villains) {
    let villainsNode = document.querySelector(".villains");

    villains.forEach(villainGroup => {
        let element = document.createElement("li");
        let p = document.createElement("p");
        let image = document.createElement("img");

        element.classList.add("col-sm");

        p.innerHTML = villainGroup.name;

        p.classList.add("text-danger", "image-label");

        image.setAttribute("src", "../img/legendary-captain-america.png");

        element.appendChild(p);
        element.appendChild(image);

        villainsNode.appendChild(element)
    })
}

function renderHeroes(heroes) {
    let heroesNode = document.querySelector(".heroes");

    heroes.forEach(hero => {
        let element = document.createElement("li");
        let p = document.createElement("p");
        let image = document.createElement("img");

        // element.innerHTML = hero.name;
        element.classList.add("col-sm");

        p.classList.add("image-label");
        p.innerHTML = hero.name;

        image.setAttribute("src", "../img/legendary-cyclops.png");

        element.appendChild(p);
        element.appendChild(image);

        heroesNode.appendChild(element)
    })
}

function renderSetup(setup) {
    renderSingle(setup["scheme"]);
    renderSingle(setup["mastermind"]);
    renderVillains(setup["villains"]);
    renderHeroes(setup["heroes"]);

    return document.querySelector(".randomSetup").innerHTML
}

function renderCleanup(cleanup) {
    document.querySelector(".bystanders").textContent = cleanup["bystanders"];
    document.querySelector(".wounds").textContent = cleanup["wounds"];
    document.querySelector(".bindings").textContent = cleanup["bindings"];
    document.querySelector(".shards").textContent = cleanup["shards"];
    document.querySelector(".sidekicks").textContent = cleanup["sidekicks"];
    document.querySelector(".ambitions").textContent = cleanup["ambitions"];

    return document.querySelector(".cleanup-generator").innerHTML
}

function removeChildren(parent) {
    while (parent.lastChild) {
        parent.removeChild(parent.lastChild)
    }
}

function removeImage(parent) {
    let img = document.querySelector(".card-image");

    parent.removeChild(img)
}

function resetForm() {
    removeChildren(document.querySelector(".scheme"));
    removeChildren(document.querySelector(".mastermind"));
    removeChildren(document.querySelector(".villains"));
    removeChildren(document.querySelector(".heroes"));

    removeImage(document.querySelector(".scheme-container"));
    removeImage(document.querySelector(".mastermind-container"));

    return document.querySelector(".randomSetup").innerHTML
}

function resetCleanup() {
    removeChildren(document.querySelector(".bystanders"));
    removeChildren(document.querySelector(".wounds"));
    removeChildren(document.querySelector(".bindings"));
    removeChildren(document.querySelector(".shards"));
    removeChildren(document.querySelector(".sidekicks"));
    removeChildren(document.querySelector(".ambitions"));

    return document.querySelector(".cleanup-generator").innerHTML
}

export default {
    renderCardSets: renderCardSets,
    renderSetup: renderSetup,
    renderCleanup: renderCleanup,
    resetForm: resetForm,
    resetCleanup: resetCleanup
};
