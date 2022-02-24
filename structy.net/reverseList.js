class Node {
    constructor(val) {
      this.val = val;
      this.next = null;
    }
  }
  
// x -> y -> z -> null  

const reverseList = (node) => {
    
    let prev = null;
    let current = node;
    let next = null;
    while (current != null) 
    {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    node = prev;
    return node;
}


const x = new Node("x");
const y = new Node("y");

x.next = y;


console.log(reverseList(x));