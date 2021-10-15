const fib = (n, arr = []) => {

    if(arr[n]) return arr[n];

    if( n <= 0) return 0;
    if( n == 1) return 1;

    arr[n] = fib(n - 1, arr) + fib (n -2, arr);
    return arr[n];
}

console.log(fib(0));
console.log(fib(-1));
console.log(fib(2));
console.log(fib(3));
console.log(fib(4));
console.log(fib(5));
console.log(fib(6));