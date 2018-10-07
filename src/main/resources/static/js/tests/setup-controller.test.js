import { CARD_SETS, SETUP, CLEANUP, HTTP_RESPONSE } from './data.js';
import SetupController from '../setup-controller.js';

beforeEach(() => {
    global.fetch = jest.fn().mockImplementation(() => new Promise(resolve => resolve(HTTP_RESPONSE)));
});

describe('setup controller gets', () => {
    test('card sets correctly', () => {
        let response = SetupController.getCardSets();

        return response.then(cardSets => {
            expect(cardSets).toBe(CARD_SETS)
        })
    });

    test('setup correctly', () => {
        const players = 4;
        const promise = new Promise(resolve => resolve(SETUP));
        const mockCallback = jest.fn(() => promise);

        let response = SetupController.getSetup(CARD_SETS, players, mockCallback);

        expect.assertions(3);

        return response.then(setup => {
            expect(mockCallback.mock.calls.length).toBe(1);
            expect(mockCallback.mock.results[0].value).toBe(promise);
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