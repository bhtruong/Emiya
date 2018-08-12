function renderCardSets(cardSets) {
    let cardSetsNode = document.querySelector(".cardSets");

    cardSets.forEach(cardSet => {
        let containerElement = document.createElement("div");
        let inputElement = document.createElement("input");
        let spanElement = document.createElement("span");

        inputElement.setAttribute("type", "checkbox");
        inputElement.setAttribute("name", cardSet);
        inputElement.setAttribute("value", cardSet);

        spanElement.innerHTML = cardSet;

        containerElement.setAttribute("class", "cardSet");
        containerElement.appendChild(inputElement);
        containerElement.appendChild(spanElement);

        cardSetsNode.appendChild(containerElement);
    });

    return cardSetsNode.innerHTML
}

function renderScheme(scheme) {
    document.querySelector(".scheme").textContent = scheme.name
}

function renderMastermind(mastermind) {
    document.querySelector(".mastermind").textContent = mastermind.name
}

function renderVillains(villains) {
    let villainsNode = document.querySelector(".villains");

    villains.forEach(villainGroup => {
        let element = document.createElement("li");
        let p = document.createElement("p");
        let image = document.createElement("img");

        element.classList.add("col-sm");

        p.innerHTML = villainGroup.name;

        p.classList.add("image-label");

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
    renderScheme(setup["scheme"]);
    renderMastermind(setup["mastermind"]);
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

function resetForm() {
    removeChildren(document.querySelector(".scheme"));
    removeChildren(document.querySelector(".mastermind"));
    removeChildren(document.querySelector(".villains"));
    removeChildren(document.querySelector(".heroes"));

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
