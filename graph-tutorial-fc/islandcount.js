const islandCount = (grid) => {
  
    let maxIsland = 0;
    // let visited = new Set();
    
    for(let r = 0; r < grid.length; r++) {
        for(let c=0; c < grid[r].length; c++) {
             
            maxIsland += exploreIsland(grid, r,c);
        }
    }
  
    console.log(maxIsland);
    return maxIsland;
};


const exploreIsland =  (grid, row, col) => {
     
    let rowInBound = row >=0 && row < grid.length;
    let colInBound = col >=0 && col < grid[0].length;
   
    if(!rowInBound || !colInBound) return 0;
  
    if(grid[row][col] === 'W') return 0;
    
    grid[row][col] = 'W'; //change current land to water;
    
    exploreIsland(grid, row - 1, col); //up
    exploreIsland(grid, row, col + 1); //right
    exploreIsland(grid, row + 1, col); //down
    exploreIsland(grid, row, col - 1); //up 
    
    return 1;
}


const grid1 = [
  ['W', 'L', 'W', 'W', 'W'],
  ['W', 'L', 'W', 'W', 'W'],
  ['W', 'W', 'W', 'L', 'W'],
  ['W', 'W', 'L', 'L', 'W'],
  ['L', 'W', 'W', 'L', 'L'],
  ['L', 'L', 'W', 'W', 'W'],
]; //3

islandCount(grid1);

const grid2 = [
    ['L', 'W', 'W', 'L', 'W'],
    ['L', 'W', 'W', 'L', 'L'],
    ['W', 'L', 'W', 'L', 'W'],
    ['W', 'W', 'W', 'W', 'W'],
    ['W', 'W', 'L', 'L', 'L'],
  ]; //4


islandCount(grid2);

const grid3 = [
    ['L', 'L', 'L'],
    ['L', 'L', 'L'],
    ['L', 'L', 'L'],
  ]; //1

islandCount(grid3);

const grid4 = [
    ['W', 'W'],
    ['W', 'W'],
    ['W', 'W'],
  ]; //0
console.log(islandCount(grid4));