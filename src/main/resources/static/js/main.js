window.onload = function() {
    var items = document.getElementsByClassName('itemCardapio');
    console.log(items.length + " itens do cardapio")
    for (var i = 0; i < items.length; i++) {
        items[i].addEventListener('click', function() {
            selectItem(this.getAttribute('data-id'));
        });
    }
}

function selectItem(id) {
    var checkbox = document.getElementById('checkSelectItem' + id);
    if(checkbox.checked) {
        checkbox.checked = false;
    } else {
        checkbox.checked = true;
    }
    console.log(checkbox.checked);
}
