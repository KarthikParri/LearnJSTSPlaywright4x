var a = "Pramod";
// 10,0000 lines
if(true){
    console.log(a);
    var a = "temp";
    console.log(a);
}

//TDZ means Temporal Dead Zone. 
// It’s the period from when a let or const variable’s scope begins until its declaration is executed.
// During that period, trying to access the variable throws a ReferenceError.