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
    let containerSelector = '', nameSelector = '';
    let image = document.createElement('img');

    image.setAttribute('src', data.imageURL);
    image.classList.add('card-image');

    if (data.type === TYPE.SCHEME) {
        containerSelector = '.scheme-container';
        nameSelector = '.scheme';
    } else if (data.type === TYPE.MASTERMIND) {
        containerSelector = '.mastermind-container';
        nameSelector = '.mastermind';
    }

    document.querySelector(containerSelector).appendChild(image);
    document.querySelector(nameSelector).textContent = data.name;
}

function renderMultiple(data) {
    let rowSelector = '', row = null;

    if (data.type === TYPE.VILLAINS) {
        rowSelector = '.villains'
    } else if (data.type === TYPE.HEROES) {
        rowSelector = '.heroes'
    }

    row = document.querySelector(rowSelector);

    data.elements.forEach(element => {
        let col = document.createElement('div');
        let name = document.createElement('p');
        let image = document.createElement('img');

        col.classList.add('col-sm');

        if (data.type === TYPE.VILLAINS) {
            name.classList.add('text-danger')
        }

        name.classList.add('image-label');
        name.innerHTML = element.name;

        image.setAttribute('src', element.imageURL);

        col.append(name);
        col.append(image);

        row.appendChild(col);
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

function removeChildren(parent) {
    while (parent.lastChild) {
        parent.removeChild(parent.lastChild)
    }
}

function removeImage(parent) {
    let img = document.querySelector('.card-image');

    parent.removeChild(img)
}

function resetForm() {
    removeChildren(document.querySelector('.scheme'));
    removeChildren(document.querySelector('.mastermind'));
    removeChildren(document.querySelector('.villains'));
    removeChildren(document.querySelector('.heroes'));

    removeImage(document.querySelector('.scheme-container'));
    removeImage(document.querySelector('.mastermind-container'));

    return document.querySelector('.randomSetup').innerHTML
}

function resetCleanup() {
    removeChildren(document.querySelector('.bystanders'));
    removeChildren(document.querySelector('.wounds'));
    removeChildren(document.querySelector('.bindings'));
    removeChildren(document.querySelector('.shards'));
    removeChildren(document.querySelector('.sidekicks'));
    removeChildren(document.querySelector('.ambitions'));

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
