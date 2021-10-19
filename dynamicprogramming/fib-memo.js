const fibmemo = (n, memo = {}) => {

    if(n in memo) return memo[n];

    if(n <= 2) return 1;

    let result = fibmemo(n-2, memo) + fibmemo(n-1, memo);
    memo[n] = result;

    return result;
}



console.log(fibmemo(6));
console.log(fibmemo(7));
console.log(fibmemo(8));
console.log(fibmemo(50)); //problem