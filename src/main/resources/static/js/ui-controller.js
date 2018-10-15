import { TYPE } from './tests/data.js';

const BUTTONS_PER_ROW = 4;

function renderCardSets(cardSets) {
    let cardSetsNode = document.querySelector('.cardSets');
    let rows = Math.ceil(cardSets.length / BUTTONS_PER_ROW);
    let rowElements = [];

    for (let i = 0; i < rows; i++) {
        let section = document.createElement('section');

        section.classList.add('row');

        rowElements.push(section)
    }

    rowElements.forEach((row, rowNumber) => {
        row.classList.add(`button-row-${rowNumber}`);
        cardSetsNode.appendChild(row)
    });

    cardSets.forEach((cardSet, index) => {
        let rowNumber = Math.floor(index / BUTTONS_PER_ROW);
        let row = document.querySelector(`.button-row-${rowNumber}`);

        let button = document.createElement('button');
        button.classList.add('btn-sm', 'btn-dark');
        button.setAttribute('type', 'button');
        button.innerText = cardSet;

        row.appendChild(button)
    });

    return cardSetsNode.innerHTML
}

function renderSingle(data) {
    let containerSelector = '', titleClass = '', htmlTemplate;
    let containerClass = 'cardImageContainer', imageClass = 'cardImage';

    if (data.type === TYPE.SCHEME) {
        containerSelector = '.scheme';
        titleClass = '"text-danger"';
    } else if (data.type === TYPE.MASTERMIND) {
        containerSelector = '.mastermind';
    }

    htmlTemplate = `
        <div class="${containerClass}">
            <p class=${titleClass}>${data.name}</p>
            <img class="${imageClass}" src=${data.imageURL}>
        </div>
    `;

    document.querySelector(containerSelector).innerHTML = htmlTemplate;
}

function renderMultiple(data) {
    let rowSelector = '', row = null, elementTemplate;

    if (data.type === TYPE.VILLAINS) {
        rowSelector = '.villains'
    } else if (data.type === TYPE.HEROES) {
        rowSelector = '.heroes'
    }

    row = document.querySelector(rowSelector);

    data.elements.forEach(element => {
        let containerClass = 'cardImageContainer', titleClass = 'image-label';
        let imageClass = 'cardImage';

        if (data.type === TYPE.VILLAINS) {
            titleClass += ' text-danger';
        }

        elementTemplate = `
            <div class="${containerClass}">
                <p class="${titleClass}">${element.name}</p>
                <img class="${imageClass}" src=${element.imageURL}>
            </div>   
        `;

        row.insertAdjacentHTML('beforeend', elementTemplate);
    })
}

function toggleButtonColor(button) {
    if (button.classList.contains('btn-dark')) {
        button.classList.replace('btn-dark', 'btn-light');
    } else if (button.classList.contains('btn-light')) {
        button.classList.replace('btn-light', 'btn-dark');
    }

    return button.classList
}

function renderSetup(setup) {
    renderSingle(setup['scheme']);
    renderSingle(setup['mastermind']);
    renderMultiple(setup['villains']);
    renderMultiple(setup['heroes']);

    return document.querySelector('.randomSetup').innerHTML
}

function renderCleanup(cleanup) {
    document.querySelector('.bystanders').textContent = cleanup['bystanders'];
    document.querySelector('.wounds').textContent = cleanup['wounds'];
    document.querySelector('.bindings').textContent = cleanup['bindings'];
    document.querySelector('.shards').textContent = cleanup['shards'];
    document.querySelector('.sidekicks').textContent = cleanup['sidekicks'];
    document.querySelector('.ambitions').textContent = cleanup['ambitions'];

    return document.querySelector('.cleanup-generator').innerHTML
}

function clearInnerHTML(parent) {
    parent.innerHTML = '';
}

function resetForm() {
    clearInnerHTML(document.querySelector('.scheme'));
    clearInnerHTML(document.querySelector('.mastermind'));
    clearInnerHTML(document.querySelector('.villains'));
    clearInnerHTML(document.querySelector('.heroes'));

    return document.querySelector('.randomSetup').innerHTML
}

function resetCleanup() {
    clearInnerHTML(document.querySelector('.bystanders'));
    clearInnerHTML(document.querySelector('.wounds'));
    clearInnerHTML(document.querySelector('.bindings'));
    clearInnerHTML(document.querySelector('.shards'));
    clearInnerHTML(document.querySelector('.sidekicks'));
    clearInnerHTML(document.querySelector('.ambitions'));

    return document.querySelector('.cleanup-generator').innerHTML
}

export default {
    renderCardSets: renderCardSets,
    renderSetup: renderSetup,
    renderCleanup: renderCleanup,
    resetForm: resetForm,
    resetCleanup: resetCleanup,
    toggleButtonColor: toggleButtonColor
};
