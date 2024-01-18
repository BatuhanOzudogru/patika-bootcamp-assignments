let buttonId = "";
let aDOM = document.getElementById("a");
aDOM.addEventListener("click", function () {
  badumts("#aSound");
});

let sDOM = document.getElementById("s");
sDOM.addEventListener("click", function () {
  badumts("#sSound");
});

let dDOM = document.getElementById("d");
dDOM.addEventListener("click", function () {
  badumts("#dSound");
});

let fDOM = document.getElementById("f");
fDOM.addEventListener("click", function () {
  badumts("#fSound");
});

let gDOM = document.getElementById("g");
gDOM.addEventListener("click", function () {
  badumts("#gSound");
});

let hDOM = document.getElementById("h");
hDOM.addEventListener("click", function () {
  badumts("#hSound");
});

let jDOM = document.getElementById("j");
jDOM.addEventListener("click", function () {
  badumts("#jSound");
});

let kDOM = document.getElementById("k");
kDOM.addEventListener("click", function () {
  badumts("#kSound");
});

let lDOM = document.getElementById("l");
lDOM.addEventListener("click", function () {
  badumts("#lSound");
});

function badumts(buttonId) {
  let sound = document.querySelector(`${buttonId}`);
  sound.play();
}
document.addEventListener("keydown", function (event) {
//   pressKey(key);
//   console.log(key);

switch (event.key) {
    case 'a':
      
      badumts("#aSound");
      break;
    case 's':
      badumts("#sSound");
      break;

    case 'd':
      badumts("#dSound");
      break;

    case 'f':
      badumts("#fSound");
      break;

    case 'g':
      badumts("#gSound");
      break;

    case 'h':
      badumts("#hSound");
      break;

    case 'j':
      badumts("#jSound");
      break;

    case 'k':
      badumts("#kSound");
      break;

    case 'l':
      badumts("#lSound");
      break;
  }
});

// function pressKey(key) {

//   let letter = `${key}`;
//   letter.toLowerCase;
  
//   switch (letter) {
//     case 'a':
      
//       badumts("#aSound");
//       break;
//     case 's':
//       badumts("#sSound");
//       break;

//     case d:
//       badumts("#dSound");
//       break;

//     case f:
//       badumts("#fSound");
//       break;

//     case g:
//       badumts("#gSound");
//       break;

//     case h:
//       badumts("#hSound");
//       break;

//     case j:
//       badumts("#jSound");
//       break;

//     case k:
//       badumts("#kSound");
//       break;

//     case l:
//       badumts("#lSound");
//       break;
//   }
// }
