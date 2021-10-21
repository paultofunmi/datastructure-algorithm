var levelOrder = function(root) {
    
    if(!root) return [];
    
    let result = [];
    
    let queue = [];
    
    queue.push(root);
    
    while(queue.length){
        
        let size = queue.length;
        let inner = [];
        
        for(let i = 0; i < size ; i++){
            
            const currentValue = queue.shift();
            inner.push(currentValue.val);
            
            if(currentValue.left) queue.push(currentValue.left);
            if(currentValue.right) queue.push(currentValue.right);
            
        }
        
        result.push(inner);
    }
    
    
    return result;
    
};

/**
 * Pseudocode
 * 
 * 
 * Time Complexity: 
 */