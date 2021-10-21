const fib = (n) => {

    if(n <=2) return 1;

    return fib(n-2) + fib(n-1);
}



// console.log(fib(6));
// console.log(fib(7));
// console.log(fib(8));
console.log(fib(50)); //problem->see fib-memo for optimized solution