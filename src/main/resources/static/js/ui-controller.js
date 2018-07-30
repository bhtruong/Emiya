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

        cardSetsNode.appendChild(containerElement)
    })
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
        element.innerHTML = villainGroup.name;
        villainsNode.appendChild(element)
    })
}

function renderHeroes(heroes) {
    let heroesNode = document.querySelector(".heroes");

    heroes.forEach(hero => {
        let element = document.createElement("li");
        element.innerHTML = hero.name;
        heroesNode.appendChild(element)
    })
}

function renderSetup(setup) {
    renderScheme(setup["scheme"]);
    renderMastermind(setup["mastermind"]);
    renderVillains(setup["villains"]);
    renderHeroes(setup["heroes"])
}

function renderCleanup(cleanup) {
    document.querySelector(".bystanders").textContent = cleanup["bystanders"];
    document.querySelector(".wounds-bindings").textContent = cleanup["wounds-bindings"];
    document.querySelector(".shards").textContent = cleanup["shards"];
    document.querySelector(".sidekicks").textContent = cleanup["sidekicks"];
    document.querySelector(".ambitions").textContent = cleanup["ambitions"]
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
    removeChildren(document.querySelector(".heroes"))
}

function resetCleanup() {
    removeChildren(document.querySelector(".bystanders"));
    removeChildren(document.querySelector(".wounds-bindings"));
    removeChildren(document.querySelector(".shards"));
    removeChildren(document.querySelector(".sidekicks"));
    removeChildren(document.querySelector(".ambitions"));
}

export default {
    renderCardSets: renderCardSets,
    renderSetup: renderSetup,
    renderCleanup: renderCleanup,
    resetForm: resetForm,
    resetCleanup: resetCleanup
};
