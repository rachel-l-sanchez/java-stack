async function buildIssueTypeDropdownMenu() {
    let array = [];
    let selectList = $("<select id='issueDropdownMenu'>");

    selectList.on('change', updateTemplateFromIssueType);

    await chrome.storage.sync.get('issueTypeTemplate', (data)=> {
        let templates = data.issueTypeTemplate();

        let issueTypeTemplateKeys = Object.keys(templates);
        issueTypeTemplateKeys.forEach((element, index) => {
            let template = templates[element]
            array.push({key: `content${index}`, value: template.name})
        })

        array.forEach(item => {
            selectList.append(
                $("<option class = 'issueDropdownMenuOptions'>")
                .attr('value', item.key)
                .text(item.value)
            )
        })
    })
    return selectList[0]
}

function updateTemplateFromIssueType(event) {
    let issueTypeDropdown = $('#issueDropdownMenu');
    let issueType = issueTypeDropdown[0].options[issueTypeDropdown[0].selectedIndex].value;

    chrome.storage.sync.get('issueTypeTemplate', data => {
        let issueTemplateTypes = data.issueTemplateTypes;
        let issueTemplate = issueTemplateTypes[issueType];
        let templateName = issueTemplate.name;

        let wikiTextEditArea = getWikiTextEditArea();
        if (wikiTextEditArea) {
            wikiTextEditArea.value = issueTemplate.content;
            trackTemplateEvent('apply', templateName);
            
        }
    })
}