const gridTraveler = (m, n, memo = {}) => {

    let key = m +"," + n;
    let key2 = n +"," + m;
    if(key in memo) return memo[key];

    if(m == 0 || n == 0) return 0;
    if(m == 1 && n == 1) return 1;

    let result = gridTraveler(m - 1, n, memo) + gridTraveler(m, n -1, memo);
    memo[key] = result;
    // memo[key2] = result;

    return result;
}


// console.log(gridTraveler(1,1));
// console.log(gridTraveler(0,1));
// console.log(gridTraveler(1,0));
console.log(gridTraveler(2,3));
// console.log(gridTraveler(18,18));