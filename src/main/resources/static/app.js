window.onload = init;

document.querySelector(".reset").addEventListener("click", () => {
    resetForm();
    resetCleanup()
});

document.querySelector("form").addEventListener("submit", event => {
    const players = document.querySelector(".players").value;
    let cardSets = [];

    event.preventDefault();

    document.querySelectorAll(".cardSet").forEach(cardSet => {
        const inputIndex = 0;
        const inputElement = cardSet.childNodes[inputIndex];

        if (inputElement.checked) {
            cardSets.push(inputElement.value)
        }
    });

    renderStubbedSetup(cardSets, players);
    renderStubbedCleanup(cardSets)
});

function init() {
    generateCardSets()
}

function generateCardSets() {
    const mockedCardSets = [
        "Legendary",
        "Dark City",
        "Fantastic Four",
        "Guardians of the Galaxy",
        "Secret Wars Vol. 1"
    ];
    let cardSetsNode = document.querySelector(".cardSets");

    mockedCardSets.forEach(cardSet => {
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

function renderCleanup(cleanup) {
    document.querySelector(".bystanders").textContent = cleanup["bystanders"];
    document.querySelector(".wounds-bindings").textContent = cleanup["wounds-bindings"];
    document.querySelector(".shards").textContent = cleanup["shards"];
    document.querySelector(".sidekicks").textContent = cleanup["sidekicks"];
    document.querySelector(".ambitions").textContent = cleanup["ambitions"]
}

function renderStubbedSetup(cardSets, players) {
    let stubbedSetup = getStubbedSetup(cardSets, players);

    stubbedSetup.then(setup => {
        renderScheme(setup["scheme"]);
        renderMastermind(setup["mastermind"]);
        renderVillains(setup["villains"]);
        renderHeroes(setup["heroes"])
    })
}

function renderStubbedCleanup(cardSets) {
    let stubbedCleanup = getStubbedCleanup(cardSets);

    stubbedCleanup.then(cleanup => renderCleanup(cleanup))
}

function getStubbedSetup(cardSets, players) {
    let stubbedSetup = {
        "scheme": {
            "name": "Pull Reality into the Negative Zone"
        },
        "mastermind": {
            "name": "Galactus"
        },
        "villains": [
            {
                "name": "Heralds of Galactus"
            },
            {
                "name": "Subterranea"
            },
            {
                "name": "Skrulls"
            },
            {
                "name": "Doombot Legion"
            },
            {
                "name": "Savage Land Mutates"
            }
        ],
        "heroes": [
            {
                "name": "Mr. Fantastic"
            },
            {
                "name": "Invisible Woman"
            },
            {
                "name": "Human Touch"
            },
            {
                "name": "Thing"
            },
            {
                "name": "Spider-Man"
            }
        ]
    };

    return new Promise(resolve => {
        setTimeout((cs, p) => {
            console.log(`Setup`);
            console.log(`Players: ${p}`);
            cs.forEach(set => console.log(`Card Set: ${set}`));

            resolve(stubbedSetup)
        }, 2500, cardSets, players)
    })
}

function getStubbedCleanup(cardSets) {
    const stubbedCleanup = {
        "bystanders": 33,
        "wounds-bindings": 30,
        "shards": 18,
        "sidekicks": 15,
        "ambitions": 30
    };

    return new Promise(resolve => {
        setTimeout(cs => {
            console.log(`Cleanup`);
            cs.forEach(set => console.log(`Card Set: ${set}`));

            resolve(stubbedCleanup)
        }, 3000, cardSets)
    })
}
