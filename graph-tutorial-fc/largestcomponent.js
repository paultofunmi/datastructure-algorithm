const largestComponent = (graph) => {
  
    let visited = new Set();
    let max = 0;
    for(let idx in graph) {
       
      max = Math.max(explore(graph, visited, idx), max);
    }
    
    console.log(max);
    return max;
  };
  
  
  
  const explore = (graph, visited, idx) => {
    
    if(visited.has(String(idx))) return 0;
    
    let count = 1;
    visited.add(String(idx));
    
    for(let neighbour of graph[idx]) {
      
       count += explore(graph, visited, neighbour);
    }
    
    // console.log('end ' +count);
    return count;
  }
  
  
  
  
  largestComponent({
    0: ['4','7'],
    1: [],
    2: [],
    3: ['6'],
    4: ['0'],
    6: ['3'],
    7: ['0'],
    8: []
  });
  