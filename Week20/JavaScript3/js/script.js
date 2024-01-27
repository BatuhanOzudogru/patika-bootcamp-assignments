const toDoListDOM = document.querySelector("#list");

const storedList = JSON.parse(localStorage.getItem("list"));

window.onload = addItemsFromStorage;

let array = storedList || []; 

function addItemsFromStorage() {

    storedList.forEach(item => {
   
        const li = document.createElement("li");
        const span = document.createElement("span");
        li.innerHTML = item;
        if(item.includes("<ch>")){
            li.classList.toggle("checked");
         }
        toDoListDOM.appendChild(li);
        span.addEventListener('click', function () {
            deleteToDoElement(this);
        });
        li.addEventListener('click', function () {
            selectToDoElement(this);
        });
        span.classList.add("close");
        span.innerHTML="x";
        li.appendChild(span);
        toDoListDOM.appendChild(li);
        
    });
}

function addToDoElement() {
    const li = document.createElement("li");
    const span = document.createElement("span");
    const toastError = document.querySelector(".error");
    const toastSuccess =document.querySelector(".success");
    let input = task.value.trim();
    if (!input) {
        task.value = "";
        var toast = new bootstrap.Toast(toastError);
        toast.show();
        return
    }
    li.textContent = input;
    span.addEventListener('click', function () {
        deleteToDoElement(this);
    });
    li.addEventListener('click', function () {
        selectToDoElement(this);
    });
    span.classList.add("close");
    span.innerHTML="x";
    li.appendChild(span);
    toDoListDOM.appendChild(li);
    task.value = "";
    var toast = new bootstrap.Toast(toastSuccess);
    toast.show();  
    array.push(input)
    localStorage.setItem("list",JSON.stringify(array))
}

function deleteToDoElement(element) {
    let listItem = element.parentElement;
    let text = listItem.textContent.trim();
    let textWithoutX= text.substring(0,text.length-1);
    if(listItem.classList.contains("checked")){

        let index = array.indexOf(`${textWithoutX}<ch>`); 
        array.splice(index, 1);
         
    }else{
       
        let index = array.indexOf(textWithoutX);
        array.splice(index, 1);
    }


    localStorage.setItem("list", JSON.stringify(array));
    listItem.remove();
}

var closeButtons = document.querySelectorAll('li .close');
    closeButtons.forEach(function (button) {
    button.addEventListener('click', function () {
        deleteToDoElement(this);
    });
});

function selectToDoElement(element) {
    var listItem = element;
    listItem.classList.toggle("checked");
    let textWithoutX= listItem.textContent.substring(0,listItem.textContent.length-1);
    if(listItem.classList.contains("checked")){
        array[array.indexOf(`${textWithoutX}`)]=`${textWithoutX}<ch>`
        localStorage.setItem("list",JSON.stringify(array))
    }else{
        array[array.indexOf(`${textWithoutX}<ch>`)]=`${textWithoutX}`
     
        localStorage.setItem("list",JSON.stringify(array))
    }
}

var listItems = document.querySelectorAll('li');
listItems.forEach(function (element) {
    element.addEventListener('click', function () {
        selectToDoElement(this);
    });
});