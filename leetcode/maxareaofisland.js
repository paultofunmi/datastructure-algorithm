/**
 * @param {number[][]} grid
 * @return {number}
 */
 var maxAreaOfIsland = function(grid) {
    
    let max = 0;
    
    for(let row = 0; row < grid.length; row++) {
        
        for(let col = 0; col < grid[row].length; col++) {
            
            let result = explore(grid, row, col);
            
            max = Math.max(result, max);
        }
    }
    
    // console.log(max);
    return max;
};



const explore = (grid, row, col) => {
    
    let rowOutBound = row < 0 || row >= grid.length;
    let colOutBound = col < 0 || col >= grid[0].length;
    
    if(rowOutBound || colOutBound) return 0;
    if(grid[row][col] == 0) return 0;
    
    let total = 1;
    grid[row][col] = 0;
    
    total += explore(grid, row - 1, col); //up
    total += explore(grid, row, col + 1); // right
    total += explore(grid, row + 1, col); // down
    total += explore(grid, row, col - 1 ); // left
    
    return total;
}


const grid1 = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]];
console.log(maxAreaOfIsland(grid1));

const grid2 = [[0,0,0,0,0,0,0,0]];
console.log(maxAreaOfIsland(grid2));