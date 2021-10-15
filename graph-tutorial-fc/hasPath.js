const hasPathDFS = (graph, source, destination) => {

    if(!graph[source] || !graph) return false;
    
    const stack = [ source ];

    while(stack.length > 0) {
        
        const current = stack.pop();
        console.log(current);
        if(current == destination) return true;

        for(let neighbour of graph[current]){
            stack.push(neighbour);
        }
    }

    return false;
};


const hasPathDFSRecursion = (graph, source, destination) => {

    if(!graph[source] || !graph) return false;
    

    console.log(source);
    if(source == destination) {

        console.log("match found");
        return true;
    }

    for(let neighbour of graph[source]){
            
        const result = hasPathDFSRecursion(graph, neighbour, destination);
        if(result) return true;
    }

    return false;
};


const hasPathBFS = (graph, source, destination) => {

    if(!graph[source] || !graph) return false;
    
    const queue = [ source ];

    while(queue.length > 0) {
        
        const current = queue.shift();
        
        if(current === destination) return true;

        for(let neighbour of graph[current]){
            queue.push(neighbour);
        }
    }

    return false;
};



const graph = {
    f: ['g', 'i'],
    g: ['h'],
    i: ['k', 'g'],
    j: ['i'],
    h: [],
    k: []
};


// const result = hasPathDFS(graph, 'f', 'k');
// const result = hasPathBFS(graph, 'f', 'j');
const result = hasPathDFSRecursion(graph, 'f', 'k');
console.log(result);