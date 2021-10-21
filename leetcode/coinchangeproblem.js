//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//Classic DP problem
var coinChange = function(coins, amount) {
    
    if(amount === 0) return 0;
    
    let result = explore(coins, amount);
    if(result === null) return -1;
    
    return result.length; 
};


const explore = (coins, amount) => {
    
    if(amount < 0 ) return null;
    if(amount == 0) return [];
    
    let smallest = null;
    
    for(let coin of coins) {
        
        let result = explore(coins, amount - coin);
        
        if(result != null) {
            const combination = [...result, coin];

            if(smallest == null || combination.length < smallest.length) {

                smallest = combination;
            }
        }
    }
    
    return smallest;
}


console.log(coinChange([2], 0));
console.log(coinChange([2, 1], 3));