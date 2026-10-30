let nums = [10,1,21,2];
nums.sort((a,b) => a-b);
console.log(nums); // Ascending Order
nums.sort((a,b) => b-a);
console.log(nums); // Descending Order

let fruits = ['apple','banana',"cherry"];
fruits.sort((a, b) => a.localeCompare(b)) // Ascending Order
console.log(fruits);
fruits.sort((a, b) => b.localeCompare(a)) // Descending Order
console.log(fruits);


// => symbol is arrow Functions in the above example. It is a short hand for function expression. It is also called as Fat Arrow Function.