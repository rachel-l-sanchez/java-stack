function applyTemplate() {
    chrome.storage.sync.get('autoApplyTemplateEnabled', (template) => {
        if (template.autoApplyTemplateEnabled) {
            populateTemplate();
        }
    })
}

function populateTemplate() {
    let wikiTextEditArea = getWikiTextEditArea();

    chrome.storage.sync.get('customTemplateEnabled', function (template) {
        if (wikiTextEditArea) {
            if (template.customTemplateEnabled) {
                chrome.storage.sync.get('customTemplate', function (data) {
                    wikiTextEditArea.value = data.customTemplate();
                })
                trackTemplateEvent('apply', 'customTemplate');

            } else {
                chrome.storage.sync.get('issueTypeTemplate', data => {
                    let issueTemplateTypes = data.issueTypeTemplate;
                    let issueTemplate = issueTemplateTypes['content0'];
                    let templateName = issueTemplate.name;

                    wikiTextEditArea.value = issueTemplate.content;

                    trackTemplateEvent('apply', templateName);
                })
            }
        }
    })
}

function getWikiTextEditArea() {
    let wikiTextEditArea = $('#description');

    let comment = $('#comment');

    if (wikiTextEditArea.length) {
        return wikiTextEditArea[0];
    }

    if (comment.length) {
        return comment[0]
    }

    return null;
}