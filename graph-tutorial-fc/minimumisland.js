const minimumIsland = (grid) => {
  
    let minSize = Infinity;
    
    for(let row = 0; row < grid.length; row++) {
      
       for(let col = 0; col < grid[row].length; col++) {
           
          const size = exploreGrid(grid, row, col);
          
          if(size > 0 && size < minSize) {
            minSize = size;
          }
       }
    }
    
    console.log(minSize);
    return minSize;
    
  };
  
  
  exploreGrid = (grid, row, col) => {
    
    let isRowInbound = row >= 0 && row < grid.length;
    let isColInbound = col >= 0 && col < grid[0].length;
    
    if(!isRowInbound || !isColInbound) return 0;
    
    if(grid[row][col] === 'W') return 0;
    
    let count = 1;
    grid[row][col] = 'W';
    
    count += exploreGrid(grid, row - 1, col); //up
    count += exploreGrid(grid, row, col + 1); //right
    count += exploreGrid(grid, row + 1, col); //down
    count += exploreGrid(grid, row, col - 1); //left
    
    return count;
  }
  
  
  
const grid1 = [
    ['L', 'W', 'W', 'L', 'W'],
    ['L', 'W', 'W', 'L', 'L'],
    ['W', 'L', 'W', 'L', 'W'],
    ['W', 'W', 'W', 'W', 'W'],
    ['W', 'W', 'L', 'L', 'L'],
];
  
minimumIsland(grid1); //2


const grid2 = [
    ['L', 'W', 'W', 'L', 'W'],
    ['L', 'W', 'W', 'L', 'L'],
    ['W', 'L', 'W', 'L', 'W'],
    ['W', 'W', 'W', 'W', 'W'],
    ['W', 'W', 'L', 'L', 'L'],
  ];
  
minimumIsland(grid2); //1


const grid3 = [
    ['L', 'L', 'L'],
    ['L', 'L', 'L'],
    ['L', 'L', 'L'],
  ];
  
minimumIsland(grid3); // -> 9

const grid4 = [
    ['W', 'W'],
    ['L', 'L'],
    ['W', 'W'],
    ['W', 'L']
  ];
  
minimumIsland(grid4); // -> 1