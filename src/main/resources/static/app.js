import UIController from './js/ui-controller.js';
import SetupController from './js/setup-controller.js';

let userCardSets = new Set();

function addCardSetClickListener() {
    document.querySelector('.cardSets').addEventListener('click', event => {
        let cardSet = event.target.innerText;

        if (userCardSets.has(cardSet)) {
            userCardSets.delete(cardSet)
        } else {
            userCardSets.add(cardSet)
        }
    });
}

//event listener to render game setup
function addSubmitEventListener() {
    document.querySelector('form').addEventListener('submit', event => {
        if (userCardSets.has('Legendary') || userCardSets.has('Legendary Villains')) {
            const players = document.querySelector('.players').value;
            let cardSets = [], setup, cleanup;

            event.preventDefault();

            document.querySelectorAll('.cardSet').forEach(cardSet => {
                //markup specific logic
                const inputIndex = 0;
                const inputElement = cardSet.childNodes[inputIndex];

                if (inputElement.checked) {
                    cardSets.push(inputElement.value)
                }
            });

            setup = SetupController.getSetup(cardSets, players);
            cleanup = SetupController.getCleanup(cardSets);

            setup.then(s => UIController.renderSetup(s));
            cleanup.then(c => UIController.renderCleanup(c));
        }
        //TODO: display message to user
    });
}

//event listener to clear game setup and cleanup
function addResetEventListener() {
    document.querySelector('.reset').addEventListener('click', () => {
        UIController.resetForm();
        UIController.resetCleanup()
    });
}

function addEventListeners() {
    addCardSetClickListener();
    addSubmitEventListener();
    addResetEventListener()
}

function resetUserCardSets() {
    userCardSets.clear()
}

function init() {
    let cardSets = SetupController.getCardSets();

    resetUserCardSets();

    cardSets.then(cs => UIController.renderCardSets(cs));

    addEventListeners()
}

window.onload = init;
