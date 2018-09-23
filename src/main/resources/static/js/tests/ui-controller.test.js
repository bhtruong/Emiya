import { CARD_SETS, SETUP, CLEANUP } from './data.js';
import UIController from '../ui-controller.js';

beforeAll(() => {
    document.body.innerHTML = `
        <section class="cardSets"></section>
        
        <div class="randomSetup">

            <div class="scheme-container">
                <h4 class="text-danger">Scheme</h4>
                <div class="scheme"></div>
            </div>

            <div class="mastermind-container">
                <h4>Mastermind</h4>
                <div class="mastermind"></div>
            </div>

            <div class="villains-container">
                <h4 class="text-danger">Villains</h4>
                <section class="villains row"></section>
            </div>

            <div class="heroes-container">
                <h4>Heroes</h4>
                <section class="heroes row"></section>
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

describe('ui controller', () => {
    test('renders card sets correctly', () => {
        const html = UIController.renderCardSets(CARD_SETS);

        expect(html).toMatchSnapshot()
    });

    test('renders setup correctly', () => {
        const html = UIController.renderSetup(SETUP);

        expect(html).toMatchSnapshot()
    });

    test('renders cleanup correctly', () => {
        const html = UIController.renderCleanup(CLEANUP);

        expect(html).toMatchSnapshot()
    });

    test('renders form reset correctly', () => {
        const html = UIController.resetForm();

        expect(html).toMatchSnapshot()
    });

    test('renders cleanup reset correctly', () => {
        const html = UIController.resetCleanup();

        expect(html).toMatchSnapshot()
    });

    test('toggles buttons correctly', () => {
        UIController.renderCardSets(CARD_SETS);

        let button = document.querySelector('.btn-sm');

        let classList = UIController.toggleButtonColor(button);

        expect(classList.contains('btn-light')).toBeTruthy();

        classList = UIController.toggleButtonColor(button);

        expect(classList.contains('btn-dark')).toBeTruthy()
    })
});