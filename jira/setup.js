function waitForIssueDialogToLoad() {
    setIntervalX(
        () => {
            let wikiTextEditArea = getWikiTextEditArea();

            if (wikiTextEditArea && !addTemplateButtonExists()) {
                addTemplateButtonToElement();
                
                applyTemplate();
            }

        }, 3000, 3, addTemplateButtonExists);
}

function attachListenerCreateIssueButton() {
    $("[original-title = 'Open Create dialog']").on('click', waitForIssueDialogToLoad);
    $('#createGlobalItem').on('click', waitForIssueDialogToLoad);


}

window.addEventListener('load', attachListenerCreateIssueButton, false);