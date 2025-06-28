let sectionIndex = document.querySelectorAll('#sections .section').length;

function addSection() {
    const template = document.getElementById('section-template').innerHTML;
    const html = template.replace(/__index__/g, sectionIndex);
    const div = document.createElement('div');
    div.innerHTML = html;
    document.getElementById('sections').appendChild(div.firstElementChild);
    sectionIndex++;
}

function removeSection(button) {
    const section = button.closest('.section');
    section.remove();
}

function addEntry(button) {
    const section = button.closest('.section');
    const entriesDiv = section.querySelector('.entries');
    const sectionId = entriesDiv.id.split('-')[1];
    const entryIndex = entriesDiv.querySelectorAll('.entry').length;
    const template = document.getElementById('entry-template').innerHTML;
    const name = 'sections[' + sectionId + '].entries[' + entryIndex + ']';
    const html = template.replace(/__name__/g, name);
    const div = document.createElement('div');
    div.innerHTML = html;
    entriesDiv.appendChild(div.firstElementChild);
}

function removeEntry(button) {
    const entry = button.closest('.entry');
    entry.remove();
}
