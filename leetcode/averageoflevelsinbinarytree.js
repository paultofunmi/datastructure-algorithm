/***
 * Node class, doInsert and BuildBST functions were added.
 * In Leetcode, you receive an object.
 */
 class Node { 

    constructor(data) {

        this.left = null;
        this.right = null;
        this.val = data;
    }

}

function doInsert(node, val) {

    if (node == null) return new Node(val);

    if(val < node.val) node.left = doInsert(node.left, val);

    if(val > node.val) node.right = doInsert(node.right, val);

    return node;
}


function buildBST(arr) {

    if(!arr) return null;
    
    let root = null;

    for(let val of arr) {

        root = doInsert(root, val);
    }

    return root;
}



/**
 * Leetcode starts here
 */
var averageOfLevels = function(root) {
    
    let result = [];
    
    let queue = [root];
    
    while(queue.length > 0) {
                
        const size = queue.length;
    
        let total = 0.0;
        let count = 0;
        
        for(let i = 0; i < size; i++) {
            
            const current = queue.shift();
            
            total += current.val;
            count++;
            
            if(current.left) queue.push(current.left);
            if(current.right) queue.push(current.right);
        }
        
        
        result.push(total / count);
        
    }
    
    
    return result;
};


const tree = buildBST([3, 20, 9, 7, 15]);
console.log(averageOfLevels(tree));