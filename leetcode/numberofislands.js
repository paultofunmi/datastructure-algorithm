var numIslands = function(grid) {
    
    let total = 0;
    
    for(let row = 0; row < grid.length; row++) {
        
        for(let col = 0; col < grid[row].length; col++) {
            
            total += traverse(grid, row, col);
        }
    }
    
    return total;
};


const traverse = (grid, row, col) => {
    
    let rowOutOfBound = row < 0 || row >= grid.length;
    let colOutOfBound = col < 0 || col >= grid[0].length;
    
    if(rowOutOfBound || colOutOfBound) return 0;
    
    if(grid[row][col] == 0) return 0;
    
    let count = 1;
    
    grid[row][col] = 0;
    
    traverse(grid, row - 1, col);
    traverse(grid, row, col + 1);
    traverse(grid, row + 1, col);
    traverse(grid, row, col - 1);
    
    return count;
}


const grid1 = [
    [ '1', '1', '1', '1', '0' ],
    [ '1', '1', '0', '1', '0' ],
    [ '1', '1', '0', '0', '0' ],
    [ '0', '0', '0', '0', '0' ]
  ]; //1
  
// console.log(numIslands(grid1));


const grid2 = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
  ]; //3
  
console.log(numIslands(grid2));

