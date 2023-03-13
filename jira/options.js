function importTemplates(event) {
    let reader = new FileReader();

    reader.onload = function(event) {
        let issueTypeTemplate = JSON.parse(event.target.result);

        chrome.storage.sync.set({issueTypeTemplate}, () => {
            getIssueTypeTemplates();
            trackTemplateEvent('import', '');
        })
    }
    reader.readAsText(event.target.files[0])
}

function exportTemplates() {
    chrome.storage.sync.get('issueTypeTemplate', () => {
       let templates = data.issueTypeTemplate;
       download("templates.json", templates);
       trackTemplateEvent('export','');
    })
}

function saveTemplates() {
    getIssueTypeTemplates();
    let templateInputs = $('textarea');
    let updatedTemplate = {}

    for (let index = 0; index< templateInputs.length; index++) {
        const element = templateInputs[index];
        const templateName = document.getElementById(`template${index}`)
        updatedTemplate[element.id] = {
            name: templateName.value,
            content: element.value
        }
    }

    chrome.storage.sync.set({issueTypeTemplate: updatedTemplate}, () => {
        let buttonText = document.getElementById('save');
        buttonText.innerHTML = 'Options saved!';

        setTimeout(() => {
            buttonText.innerHTML = 'Save';
        }, 1000);
        console.log('Issue template types updated');
        trackTemplateEvent('save', '');
     });

     getIssueTypeTemplates();


}

