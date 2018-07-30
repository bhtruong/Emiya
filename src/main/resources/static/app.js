import UIController from "./js/ui-controller.js";
import SetupController from "./js/setup-controller.js";

//event listener to render game setup
function addSubmitEventListener() {
    document.querySelector("form").addEventListener("submit", event => {
        const players = document.querySelector(".players").value;
        let cardSets = [], setup, cleanup;

        event.preventDefault();

        document.querySelectorAll(".cardSet").forEach(cardSet => {
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
    });
}

//event listener to clear game setup and cleanup
function addResetEventListener() {
    document.querySelector(".reset").addEventListener("click", () => {
        UIController.resetForm();
        UIController.resetCleanup()
    });
}

function addEventListeners() {
    addSubmitEventListener();
    addResetEventListener()
}

function init() {
    let cardSets = SetupController.getCardSets();

    cardSets.then(cs => UIController.renderCardSets(cs));

    addEventListeners()
}

window.onload = init;
