class Node { 

    constructor(data) {

        this.left = null;
        this.right = null;
        this.data = data;
    }

}

function doInsert(node, val) {

    if (node == null) return new Node(val);

    if(val < node.data) node.left = doInsert(node.left, val);

    if(val > node.data) node.right = doInsert(node.right, val);

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

// 
console.log(buildBST([3]));
console.log('--------------------');
console.log(buildBST(null));
console.log('--------------------');
console.log(buildBST([3, 9]));
console.log('--------------------');
console.log(buildBST([3, 9, 20]));
console.log('--------------------');
console.log(buildBST([5,2, 7, 1]));
