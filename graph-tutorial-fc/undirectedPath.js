const undirectedPath = (edges, nodeA, nodeB) => {
  
    const graph = buildGraph(edges);
   
    const result = findPath(graph, nodeA, nodeB, new Set());
    console.log(result);

    return result;
 };
 
 
 const findPath = (graph, source, dst, visited) => {
   
   if(visited.has(source)) return;
   
   visited.add(String(source));
   
   if(source === dst) return true;
   
   for(let neighbour of graph[source]) {
      
       if(findPath(graph, neighbour, dst, visited)) return true;
   }
   
   return false;
 }
 
 const buildGraph = (edges) => {
   
   const graph = {};
   
   for(const val of edges) {
     
      const [a, b]  = val;
     
    //   if(!graph[a]) graph[a] = [];
    //   if(!graph[b]) graph[b] = [];
    if(!(a in graph)) graph[a] = [];
    if(!(b in graph)) graph[b] = [];
      
     graph[a].push(b);
     graph[b].push(a);
   }
   
   return graph;
 }
 
 
 const edges = [
   ['i', 'j'],
   ['k', 'i'],
   ['m', 'k'],
   ['k', 'l'],
   ['o', 'n']
 ];
 
 undirectedPath(edges, 'j', 'm'); // -> true
