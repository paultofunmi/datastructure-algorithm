function maxRegion(grid) {
    
    let max = -1;
  
    for(let row = 0; row < grid.length; row++) {
    
     for(let col = 0; col < grid[row].length; col++) {
         
            max = Math.max(max, exploreGrid(grid, row, col));
        
       }
    }
  
  console.log(max);
  return max;
  
}

const exploreGrid = (grid, row, col) => {
    
    let isRowInbound = row >= 0 && row < grid.length;
    let isColInbound = col >= 0 && col < grid[0].length;
    
    if(!isRowInbound || !isColInbound) return 0;
    
    if(grid[row][col] === 0) return 0;
    
    let count = 1;
    grid[row][col] = 0;
    
    count += exploreGrid(grid, row - 1, col); //up
    count += exploreGrid(grid, row, col + 1); //right
    count += exploreGrid(grid, row + 1, col); //down
    count += exploreGrid(grid, row, col - 1); //left

    //diagonal
    count += exploreGrid(grid, row -1 , col - 1); //left upper
    count += exploreGrid(grid, row + 1, col - 1); //left lower
    count += exploreGrid(grid, row + 1, col + 1); //right lower
    count += exploreGrid(grid, row - 1, col + 1); //right upper
    
    return count;
}

const grid = [
    [0, 0, 1, 1],
    [0, 0, 1, 0],
    [0, 1, 1, 0],
    [0, 1, 0, 0],
    [1, 1, 0, 0],
]; //8

maxRegion(grid);

const grid2 = [
    [1, 1, 0, 0],
    [0, 1, 1, 0],
    [0, 0, 1, 0],
    [1, 0, 0, 0],
]; //5

maxRegion(grid2);

