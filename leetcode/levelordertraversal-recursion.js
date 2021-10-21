var levelOrder = function(root) {
    
    if(!root) return [];
    
    let obj = traverse(root, 0);
    
    return obj;
};


const traverse = (node, level, obj = []) => {
    
    if(node == null) return;
    
    if(!obj[level]) {
        
        obj[level] = [];
        
    }   
       
    obj[level].push(node.val);

    traverse(node.left, level + 1, obj);
    traverse(node.right, level + 1, obj);

   
    return obj;
}