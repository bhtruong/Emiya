import { CARD_SETS, SETUP, CLEANUP } from "./data.js";
import UIController from "../ui-controller.js";

beforeAll(() => {
    document.body.innerHTML = `
        <section class="cardSets"></section>
        
        <div class="randomSetup">
        
            <div class="scheme-container">
                <h4 class="text-danger">Scheme</h4>
                <p class="text-danger scheme"></p>
            </div>
            
            <div class="mastermind-container">
                <h4>Mastermind</h4>
                <p class="mastermind"></p>
            </div>
            
            <div class="villains-container">
                <h4 class="text-danger">Villains</h4>
                <ul class="villains row"></ul>
            </div>
            
            <div class="heroes-container">
                <h4>Heroes</h4>
                <ul class="heroes row"></ul>
            </div>
            
        </div>
        
        <div class="cleanup-generator">
            <h2>Clean Up</h2>
            <h4>Bystanders</h4>
            <p class="bystanders"></p>
            <h4>Wounds</h4>
            <p class="wounds"></p>
            <h4>Bindings</h4>
            <p class="bindings"></p>
            <h4>Shards</h4>
            <p class="shards"></p>
            <h4>Sidekicks</h4>
            <p class="sidekicks"></p>
            <h4>Ambitions</h4>
            <p class="ambitions"></p>
        </div>`;
});

describe("ui controller renders", () => {
    test("card sets correctly", () => {
        const html = UIController.renderCardSets(CARD_SETS);

        expect(html).toMatchSnapshot()
    });

    test("setup correctly", () => {
        const html = UIController.renderSetup(SETUP);

        expect(html).toMatchSnapshot()
    });

    test("cleanup correctly", () => {
        const html = UIController.renderCleanup(CLEANUP);

        expect(html).toMatchSnapshot()
    });

    test("form reset correctly", () => {
        const html = UIController.resetForm();

        expect(html).toMatchSnapshot()
    });

    test("cleanup reset correctly", () => {
        const html = UIController.resetCleanup();

        expect(html).toMatchSnapshot()
    });
});