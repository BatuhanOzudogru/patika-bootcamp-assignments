const toDoListDOM = document.querySelector("#list");


function addToDoElement() {
    const li = document.createElement("li");
    const span = document.createElement("span");
    let input = task.value.trim();
    if (input.length === 0) {
        task.value = "";
        $(".error").toast("show");
        return
    }
    li.textContent = input;
    span.textContent = "x";
    span.className = "close";
    span.addEventListener('click', function () {
        deleteToDoElement(this);
    });
    li.appendChild(span);
    li.addEventListener('click', function () {
        selectToDoElement(this);
    });
    toDoListDOM.appendChild(li);
    task.value = "";
    $(".success").toast("show");
    
}


function deleteToDoElement(element) {
    var listItem = element.parentElement;
    listItem.style.display = "none";
}


var closeButtons = document.querySelectorAll('.close');
closeButtons.forEach(function (button) {
    button.addEventListener('click', function () {
        deleteToDoElement(this);
    });
});




function selectToDoElement(element) {
    var listItem = element;
    listItem.classList.toggle("checked");
}

var listItems = document.querySelectorAll('li');
listItems.forEach(function (click) {
    click.addEventListener('click', function () {
        selectToDoElement(this);
    });
});