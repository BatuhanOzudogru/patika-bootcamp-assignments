let namePrompt= prompt("Please enter your name");

let nameDOM = document.querySelector("#myName");

nameDOM.innerHTML = namePrompt;

function showTime() {
    const date = new Date();
    let day = getDayName();
    let hour = date.getHours();
    let minute = date.getMinutes();
    let second = date.getSeconds();
    minute = checkTime(minute);
    second = checkTime(second);
    document.getElementById('myClock').innerHTML =  hour + ":" + minute + ":" + second + " " + day;
    setTimeout(showTime, 500);
  }
  
  function checkTime(i) {
    if (i < 10) {i = "0" + i};  
    return i;
  }

  function getDayName(date = new Date(), locale = 'en-US') {
    return date.toLocaleDateString(locale, {weekday: 'long'});
  }