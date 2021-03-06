const howsum = (arr, target, memo = {}) => {

    if(target in memo) return memo[target];
    if(target < 0) return null;
    if(target == 0) return [];

    for(let val of arr) {
        
        let res = howsum(arr, target - val, memo);
        if(res != null) {
            memo[target] = res;
            return [ ...res, val];
        }
    }

    memo[target] = null;
    return null;
}



console.log(howsum([2,3, 7], 7));
console.log(howsum([2,4], 7));
console.log(howsum([2,3, 5], 8));
console.log(howsum([7,14], 300));