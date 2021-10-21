const bestsum = (arr, target, memo = {}) => {

    if(target in memo) return memo[target];
    if(target < 0) return null;
    if(target == 0) return [];

    for(let val of arr) {
        
        let res = bestsum(arr, target - val, memo);
        if(res != null) {
            memo[target] = res;
            return [ ...res, val];
        }
    }

    memo[target] = null;
    return null;
}



console.log(bestsum([2,3, 5], 5)); //5
console.log(bestsum([5,3,4,7], 7)); //7
console.log(bestsum([1,4, 5], 8)); //4, 4
console.log(bestsum([7,14], 300));
console.log(bestsum([1,2, 5, 25], 100));