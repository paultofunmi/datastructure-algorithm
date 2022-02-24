const undirectedPath = (edges, nodeA, nodeB) => {
  
    const graph = buildGraph(edges);
    console.log(graph);
   
    return findPath(graph, nodeA, nodeB, new Set());
 };
 
 const buildGraph = (edges) => {
   
   const graph = {};
   
   for(const val of edges) {
     
      const [a, b]  = val;
     
      if(!graph[a]) graph[a] = [];
      if(!graph[b]) graph[b] = [];
      
     graph[a].push(b);
     graph[b].push(a);
   }
   
   return graph;
 }
 
 const findPath = (graph, source, dst, visited) => {
   
   if(visited.has(source)) return false;
   
   visited.add(source);
   
   if(source === dst) return true;
   
   for(let neighbour of graph[source]) {
      
       if(findPath(graph, neighbour, dst, visited)) return true;
   }
   
   return false;
 }
 
 
 const edges = [
   ['i', 'j'],
   ['k', 'i'],
   ['m', 'k'],
   ['k', 'l'],
   ['o', 'n']
 ];
 
console.log(undirectedPath(edges, 'i', 'l')); // -> true
 
 