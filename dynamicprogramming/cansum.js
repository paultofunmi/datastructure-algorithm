const canSum = (arr, target, memo = {}) => {
    
    if( target in memo) return memo[target];
    if(target == 0) return true;

    if(target < 0) return false;

    for(let i of arr) {

        if(canSum(arr, target - i, memo) == true) {

            memo[target] = true;
            
            return true;
        }
    }

    memo[target] = false;
    return false;
}


console.log(canSum([5,3, 4, 7], 7)); //true
console.log(canSum([2,3], 7)); //true
console.log(canSum([2,4], 7)); //false
console.log(canSum([2,3,5], 8)); //true
console.log(canSum([7,14], 300)); //false
