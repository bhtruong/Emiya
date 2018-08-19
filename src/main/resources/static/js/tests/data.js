export const TYPE = {
    'SCHEME': 0,
    'MASTERMIND': 1,
    'VILLAINS': 2,
    'HEROES': 3
};

export const CARD_SETS = [
    "Legendary",
    "Dark City",
    "Fantastic Four",
    "Guardians of the Galaxy",
    "Paint the Town Red",
    "Secret Wars Vol. 1",
    "Secret Wars Vol. 2",
    "X-Men",
    "World War Hulk"
];

export const SETUP = {
    scheme: {
        type: TYPE.SCHEME,
        name: "Pull Reality into the Negative Zone",
        imageURL: "../img/legendary-nick-fury.png"
    },
    mastermind: {
        type: TYPE.MASTERMIND,
        name: "Galactus",
        imageURL: "../img/legendary-iron-man.png"
    },
    villains: {
        type: TYPE.VILLAINS,
        elements: [
            {
                name: "Heralds of Galactus",
                imageURL: "../img/legendary-captain-america.png"
            },
            {
                name: "Subterranea",
                imageURL: "../img/legendary-captain-america.png"
            },
            {
                name: "Skrulls",
                imageURL: "../img/legendary-captain-america.png"
            },
            {
                name: "Doombot Legion",
                imageURL: "../img/legendary-captain-america.png"
            },
            {
                name: "Savage Land Mutates",
                imageURL: "../img/legendary-captain-america.png"
            }]
    },
    heroes: {
        type: TYPE.HEROES,
        elements: [
            {
                name: "Mr. Fantastic",
                imageURL: "../img/legendary-cyclops.png"
            },
            {
                name: "Invisible Woman",
                imageURL: "../img/legendary-cyclops.png"
            },
            {
                name: "Human Torch",
                imageURL: "../img/legendary-cyclops.png"
            },
            {
                name: "Thing",
                imageURL: "../img/legendary-cyclops.png"
            },
            {
                name: "Spider-Man",
                imageURL: "../img/legendary-cyclops.png"
            }
        ]
    }
};

export const CLEANUP = {
    bystanders: 33,
    wounds: 30,
    bindings: 0,
    shards: 18,
    sidekicks: 15,
    ambitions: 30
};