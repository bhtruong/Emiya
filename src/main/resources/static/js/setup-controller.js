function getStubbedCardSets() {
    const stubbedCardSets = [
        "Legendary",
        "Dark City",
        "Fantastic Four",
        "Guardians of the Galaxy",
        "Secret Wars Vol. 1"
    ];

    return new Promise(resolve => {
        setTimeout(() => {
            console.log(`Card Sets`);

            resolve(stubbedCardSets);
        }, 1250);
    })
}

function getStubbedSetup(cardSets, players) {
    const stubbedSetup = {
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

export default {
    getCardSets: getStubbedCardSets,
    getSetup: getStubbedSetup,
    getCleanup: getStubbedCleanup
};
