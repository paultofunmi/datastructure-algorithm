const fib = (number, memo = {}) => {

    if(number in memo) return memo[number];
    if(number <= 2) return 1;

    let result = fib(number -2, memo) + fib(number -1, memo);
    memo[number] = result;

    return result;
}


// console.log(fib(-1));
// console.log(fib(2));
// console.log(fib(3));
// console.log(fib(4));
// console.log(fib(5));
// console.log(fib(6));
console.log(fib(50));