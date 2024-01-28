const jokes = [
    "Chuck Norris doesn't read books. He stares them down until he gets the information he wants.",
    "Time waits for no man. Unless that man is Chuck Norris",
    "If you spell Chuck Norris in Scrabble, you win. Forever.",
    "When God said, “Let there be light!” Chuck Norris said, “Say Please.”",
    "Chuck Norris does not own a stove, oven or microwave, because revenge is a dish best served cold.",
    "Chuck Norris does not sleep. He waits.",
    "If paper beats rock, rock beats scissors, and scissors beats paper, what beats all 3 at the same time? Chuck Norris.",
    "Chuck Norris' roundhouse kick is so powerful, it can be seen from outer space by the naked eye.",
    "Chuck Norris has never blinked in his entire life. Never.",
    "Chuck Norris counted to infinity... twice.",
    "Chuck Norris can speak Braille.",
    "Chuck Norris can have both feet on the ground and kick butt at the same time.",
    "Chuck Norris can do a wheelie on a unicycle.",
    "Once a cobra bit Chuck Norris' leg. After five days of excruciating pain, the cobra died.",
    "Chuck Norris once won a game of Connect Four in three moves.",
    "Champions are the breakfast of Chuck Norris.",
    "When the Boogeyman goes to sleep every night he checks his closet for Chuck Norris.",
    "Chuck Norris can slam revolving doors.",
    "Chuck Norris stands faster than anyone can run.",
    "Chuck Norris does not hunt because the word hunting implies the possibility of failure. Chuck Norris goes killing.",
    "The dark is afraid of Chuck Norris.",
    "Chuck Norris can kill two stones with one bird.",
    "Chuck Norris can play the violin with a piano.",
    "Chuck Norris makes onions cry.",
    "Death once had a near-Chuck-Norris experience.",
    "When Chuck Norris writes, he makes paper bleed.",
    "Chuck Norris can strangle you with a cordless phone."
]


const buttonDOM = document.querySelector("#btn");
const pDOM =document.querySelector("#joke");


buttonDOM.addEventListener('click', displayRandomJoke);
window.onload = displayRandomJoke;



// buttonDOM.addEventListener('click' ,(e)=> {
//         const random = Math.floor(Math.random() * jokes.length);
//         pDOM.textContent=jokes[random];
// });


function displayRandomJoke() {
    const random = Math.floor(Math.random() * jokes.length);
    pDOM.textContent = jokes[random];
}