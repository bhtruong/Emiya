window.onload = init

document.querySelector(".reset").addEventListener("click", () => resetForm())

document.querySelector("form").addEventListener("submit", event => {
    var players = document.querySelector(".players").value
    var cardSets = []

    event.preventDefault()

    document.querySelectorAll(".cardSet").forEach(cardSet => {
        if (cardSet.checked) {
            cardSets.push(cardSet.value)
        }
    })

    renderMockedSetup(cardSets, players)
})

function init() {
    generateCardSets()
}

function generateCardSets() {
    var mockedCardSets = [
        "Legendary",
        "Dark City",
        "Fantastic Four",
        "Guardians of the Galaxy",
        "Secret Wars Vol. 1"
    ]
    var cardSetsNode = document.querySelector(".cardSets")

    mockedCardSets.forEach(cardSet => {
        var containerElement = document.createElement("div")
        var inputElement = document.createElement("input")
        var spanElement = document.createElement("span")

        inputElement.setAttribute("type", "checkbox")
        inputElement.setAttribute("name", cardSet)
        inputElement.setAttribute("value", cardSet)

        spanElement.innerHTML = cardSet

        containerElement.setAttribute("class", "cardSet")
        containerElement.appendChild(inputElement)
        containerElement.appendChild(spanElement)

        cardSetsNode.appendChild(containerElement)
    })
}

function removeChildren(parent) {
    while (parent.lastChild) {
        parent.removeChild(parent.lastChild)
    }
}

function resetForm() {
    removeChildren(document.querySelector(".scheme"))
    removeChildren(document.querySelector(".mastermind"))
    removeChildren(document.querySelector(".villains"))
    removeChildren(document.querySelector(".heroes"))
}

function renderScheme(scheme) {
    document.querySelector(".scheme").textContent = scheme.name
}

function renderMastermind(mastermind) {
    document.querySelector(".mastermind").textContent = mastermind.name
}

function renderVillains(villains) {
    var villainsNode = document.querySelector(".villains")

    villains.forEach(villainGroup => {
        var element = document.createElement("li")
        element.innerHTML = villainGroup.name
        villainsNode.appendChild(element)
    })
}

function renderHeroes(heroes) {
    var heroesNode = document.querySelector(".heroes")

    heroes.forEach(hero => {
        var element = document.createElement("li")
        element.innerHTML = hero.name
        heroesNode.appendChild(element)
    })
}

function renderMockedSetup(cardSets, players) {
    var mockedSetup = {
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
    }

    renderScheme(mockedSetup["scheme"])
    renderMastermind(mockedSetup["mastermind"])
    renderVillains(mockedSetup["villains"])
    renderHeroes(mockedSetup["heroes"])
}