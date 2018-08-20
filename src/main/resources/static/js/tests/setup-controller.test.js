import { CARD_SETS, SETUP, CLEANUP } from './data.js';
import SetupController from '../setup-controller.js';

describe('setup controller gets', () => {
    test('card sets correctly', () => {
        let response = SetupController.getCardSets();

        expect.assertions(1);

        return response.then(cardSets => {
            expect(cardSets).toBe(CARD_SETS)
        })
    });

    test('setup correctly', () => {
        const players = 4;
        let response = SetupController.getSetup(CARD_SETS, players);

        expect.assertions(1);

        return response.then(setup => {
            expect(setup).toBe(SETUP)
        })
    });

    test('cleanup correctly', () => {
        let response = SetupController.getCleanup(CARD_SETS);

        expect.assertions(1);

        return response.then(cleanup => {
            expect(cleanup).toBe(CLEANUP)
        })
    })
});