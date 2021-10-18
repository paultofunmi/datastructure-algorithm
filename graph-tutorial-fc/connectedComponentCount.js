const connectedComponentsCount = (graph) => {
  
    let result = 0;
    let visited = new Set();
    for(let idx in graph) {
      
      if(count(graph, idx, visited)) result++;
    }
    
    // console.log(result);
    return result;
  };
  
  
  const count = (graph, idx, visited) => {
    
    // console.log(visited);
    if(visited.has(String(idx))) return false;
  
     visited.add(String(idx));
      
     for(let neighbour of graph[idx]) {
        
        count(graph, neighbour, visited);
     }
    
     return true;
  }
  
  let graph1 = {
    0: [8, 1, 5],
    1: [0],
    5: [0, 8],
    8: [0, 5],
    2: [3, 4],
    3: [2, 4],
    4: [3, 2]
  }; //2

let graph2 = {
    3: [],
    4: [6],
    6: [4, 5, 7, 8],
    8: [6],
    7: [6],
    5: [6],
    1: [2],
    2: [1]
}; //3

let graph3 = {}; //0

connectedComponentsCount(graph1);
connectedComponentsCount(graph2);
connectedComponentsCount(graph3);
  