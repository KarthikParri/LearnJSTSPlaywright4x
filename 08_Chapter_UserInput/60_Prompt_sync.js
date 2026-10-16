const prompt = require("prompt-sync")();
let num = Number(prompt("Enter a number"));
console.log(num);
// If we want to run this we have to use Node.js
// This is the only way to take user input in Node.js. In browser, we can use prompt() function to take user input.
// To run this code, we have to install prompt-sync package. We can install it by running the following command in terminal:
// npm i prompt-sync
//To run this code, we have to run the following command in terminal:
// node 08_Chapter_UserInput/60Prompt_sync.js
