const playerOneDiceDOM = document.querySelector("#player1Dice");
const playerTwoDiceDOM = document.querySelector("#player2Dice");
const rollButtonDOM = document.querySelector("#roll");
const resultDOM = document.querySelector("#result");
const playerOneTextDOM = document.querySelector("#player1Text");
const infoDOM = document.querySelector(".info");

const dices = ["1","2","3","4","5","6"];


playerOneTextDOM.addEventListener("dblclick", () => {
    infoDOM.innerHTML="";
    const newName = prompt("Enter new name for Player 1:");
    if (newName) {
        playerOneTextDOM.textContent = newName;
    }
});

rollButtonDOM.addEventListener("click", ()=>{
    infoDOM.innerHTML="";
    rollButtonDOM.disabled = true;
    const rollDiceAnimation = () => {
        const random1 = Math.floor(Math.random() * dices.length) + 1;
        const random2 = Math.floor(Math.random() * dices.length) + 1;
        playerOneDiceDOM.src = `assets/dice${random1}.png`;
        playerTwoDiceDOM.src = `assets/dice${random2}.png`;
    };
    const interval = setInterval(rollDiceAnimation, 50);
    
    setTimeout(() => {
        clearInterval(interval);
        const random1 = Math.floor(Math.random() * dices.length) + 1;
        const random2 = Math.floor(Math.random() * dices.length) + 1;
        playerOneDiceDOM.src = `assets/dice${random1}.png`;
        playerTwoDiceDOM.src = `assets/dice${random2}.png`;
        if (random1 > random2) {
            resultDOM.textContent = `${playerOneTextDOM.textContent} WON`;
        } else if (random2 > random1) {
            resultDOM.textContent = "Player 2 WON";
        } else {
            resultDOM.textContent = "DRAW";
        }
        rollButtonDOM.disabled = false;
    },500);

});