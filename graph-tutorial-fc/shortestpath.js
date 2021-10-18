const shortestPath = (edges, nodeA, nodeB) => {

    const graph = buildGraph(edges);
    const queue = [[nodeA, 0]];
   
    const result = findPath(graph, queue, nodeB);
    console.log(result);
    return result;
 };
 
 
 const findPath = (graph, queue, nodeB) => {
   
    let visited = new Set();
    while(queue.length > 0) {
      
      const [node, distance] = queue.shift();
      visited.add(node);
      
      if(node === nodeB) { 
        return distance; 
      }
      
      for(let neighbour of graph[node]) {
          
          if(!visited.has(neighbour)) {
             queue.push([neighbour, distance + 1]);  
          }
      }
    }
   
    return -1;
 }
 
 const buildGraph = (edges) => {
   
    const graph = {};
   
    for(let arr of edges) {
      
       const [a,b] = arr;
       
       if(!graph[a]) graph[a] = [];
       if(!graph[b]) graph[b] = [];
      
       graph[a].push(b);
       graph[b].push(a);
    }
   
    // console.log(graph);
    return graph;
   
 }
 
 
 // const edges = [
 //   ['a', 'c'],
 //   ['a', 'b'],
 //   ['c', 'b'],
 //   ['c', 'd'],
 //   ['b', 'd'],
 //   ['e', 'd'],
 //   ['g', 'f']
 // ];
 
 // shortestPath(edges, 'b', 'g'); // -> -1
 
 // const edges1 = [
 //   ['w', 'x'],
 //   ['x', 'y'],
 //   ['z', 'y'],
 //   ['z', 'v'],
 //   ['w', 'v']
 // ]; //2
 
 // const edges2 = [
 //   ['w', 'x'],
 //   ['x', 'y'],
 //   ['z', 'y'],
 //   ['z', 'v'],
 //   ['w', 'v']
 // ]; 
 
 // shortestPath(edges, 'y', 'x'); // -> 1
 // shortestPath(edges, 'w', 'z');
