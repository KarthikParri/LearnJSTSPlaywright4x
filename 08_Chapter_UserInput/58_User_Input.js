//we are not able to run because its broswer-based code which works only in browser.
// Javascript was created as a browser-based code. So, we can run this code in browser console only.
let num = prompt("Enter a number:");
num = Number(num);  // convert string to number

if (num % 2 === 0) {
    console.log(num + " is Even");
} else {
    console.log(num + " is Odd");
}