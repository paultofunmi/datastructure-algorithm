const hasPath = (graph, src, dst) => {
    // todo
    if(src == dst) return true;
    
    for(let neighbour of graph[src]) {
      
    //   console.log(`ngh: ${neighbour}`)
      if(hasPath(graph, neighbour, dst)) return true;
    }
    
    return false;
};


const graph = {
    f: ['g', 'i'],
    g: ['h'],
    h: [],
    i: ['g', 'k'],
    j: ['i'],
    k: []
};
  
console.log(hasPath(graph, 'f', 'k')); // true


// const graph1 = {
//     f: ['g', 'i'],
//     g: ['h'],
//     h: [],
//     i: ['g', 'k'],
//     j: ['i'],
//     k: []
//   };
  
//   hasPath(graph1, 'f', 'j'); // false

//   const graph2 = {
//     f: ['g', 'i'],
//     g: ['h'],
//     h: [],
//     i: ['g', 'k'],
//     j: ['i'],
//     k: []
//   };
  
//   hasPath(graph2, 'i', 'h'); // true