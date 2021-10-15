const printDFSIterative = (graph, source) => {
    const stack = [ source ];

    while(stack.length > 0) {
        const current = stack.pop();
        console.log(current);

        for(let neighbour of graph[current]){
            stack.push(neighbour);
        }
    }
};


const printDFSRecursion = (graph, source) => {

    console.log(source);

    for(let neighbour of graph[source]){
        
        printDFSRecursion(graph, neighbour);
    }

};

const graph = {
    a: ['b', 'c'],
    b: ['d'],
    c: ['e'],
    d: ['f'],
    e: [],
    f: []
};

// printDFSIterative(graph, 'a');
printDFSRecursion(graph, 'c');