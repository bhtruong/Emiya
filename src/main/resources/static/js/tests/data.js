export const TYPE = {
    'SCHEME': 0,
    'MASTERMIND': 1,
    'VILLAIN': 2,
    'HERO': 3
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
    villains: [
        {
            name: "Heralds of Galactus"
        },
        {
            name: "Subterranea"
        },
        {
            name: "Skrulls"
        },
        {
            name: "Doombot Legion"
        },
        {
            name: "Savage Land Mutates"
        }
    ],
    heroes: [
        {
            name: "Mr. Fantastic"
        },
        {
            name: "Invisible Woman"
        },
        {
            name: "Human Torch"
        },
        {
            name: "Thing"
        },
        {
            name: "Spider-Man"
        }
    ]
};

export const CLEANUP = {
    bystanders: 33,
    wounds: 30,
    bindings: 0,
    shards: 18,
    sidekicks: 15,
    ambitions: 30
};