import { CARD_SETS, SETUP, CLEANUP } from './tests/data.js';

function getStubbedCardSets() {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(CARD_SETS);
        }, 1250);
    })
}

function getStubbedSetup(cardSets, players) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(SETUP)
        }, 2500, cardSets, players)
    })
}

function getStubbedCleanup(cardSets) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(CLEANUP)
        }, 3000, cardSets)
    })
}

const getRandomSetup = (cardSets, players, callback = response => response.json()) => {
    const url = `/api/randomSetup?players=${players}`;
    const options = {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(cardSets)
    };

    return fetch(url, options)
        .then(callback)
        .catch(err => {
            console.log('Failed to get random setup', err);
            throw err;
        });
};

export default {
    getCardSets: getStubbedCardSets,
    getSetup: getRandomSetup,
    getCleanup: getStubbedCleanup
};
