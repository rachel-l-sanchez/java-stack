function clearTemplate() {
    let wikiTextEditArea = getWikiTextEditArea();
    if (wikiTextEditArea) {
        wikiTextEditArea.value = '';
        trackTemplateEvent('clear', '');
    }
}