// Type 1 - No param / argument, No Return -> final retunr undefined.


// Fn Define
function greet(){
  console.log("Hello, TheTesting Academy");  
}

// Fn Calling
greet()
greet()
greet()
greet()


function openBrowser(){
    console.log("Open Browser");
    // open the brower
}

openBrowser();


let msg = greet(); // Here greet() is called and it will print "Hello, TheTesting Academy" 
// but since there is no return statement in the function, msg will be undefined.

console.log(msg); // undefined there is no return.