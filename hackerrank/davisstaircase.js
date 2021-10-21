function stepPerms(n) {

    return countWays(n , [1,2,3]);
}


const countWays = (target, arr, memo = {}) => {
        
     if(target in memo) return memo[target];   
     if(target == 0) return 1;
     if(target < 0) return 0;
     
     let totalWays = 0;
     
     for(let val of arr) {
        
        let result = countWays(target - val, arr, memo);    
        totalWays += result;
        memo[target - val] = result;  
     }
     
     
     return totalWays;   
}


console.log(stepPerms(1)); //1
console.log(stepPerms(3)); //4
console.log(stepPerms(7)); //44

console.log(stepPerms(5)); //13
console.log(stepPerms(8)); //81

console.log(stepPerms(15)); //5768
console.log(stepPerms(20)); //121415
console.log(stepPerms(27)); //8646064