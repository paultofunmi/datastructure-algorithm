/**
 * Write a function, connectedComponentsCount, that takes in the adjacency list of an undirected graph. 
 * The function should return the number of connected components within the graph.
 */

const connectedComponentsCount = (graph) => {
  
    let result = 0;
    let visited = new Set();
    for(let idx in graph) {
      
      result += count(graph, idx, visited);
    }
    
    console.log(result);
    return result;
  };
  
  
  const count = (graph, idx, visited) => {
    
    // console.log(visited);
    if(visited.has(String(idx))) return 0;
  
     visited.add(String(idx));
      
     for(let neighbour of graph[idx]) {
        
        count(graph, neighbour, visited);
     }
    
     return 1;
  }
  
  connectedComponentsCount({
    0: [8, 1, 5],
    1: [0],
    5: [0, 8],
    8: [0, 5],
    2: [3, 4],
    3: [2, 4],
    4: [3, 2]
  });