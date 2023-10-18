function onlyOne(checkbox) {
    let checkboxes = document.getElementsByName('idAnswer')
    checkboxes.forEach((item) => {
        if (item !== checkbox) item.checked = false
    })
}