
class SinglyLinkedListNode {

    constructor(data) {
        this.data = data;
        this.next = null;
    }     
}
  
 
function mergeLists(head1, head2) {

    if(head1 == null) return head2;
    if(head2 == null) return head1;

    if (head1.data < head2.data) {
        head1.next = mergeLists(head1.next, head2);
        return head1;
    } else {
        head2.next = mergeLists(head1, head2.next);
        return head2;
    }
}


const h1 = new SinglyLinkedListNode(1);
const h2 = new SinglyLinkedListNode(3);
const h3 = new SinglyLinkedListNode(7);
h1.next = h2;
h2.next = h3;

const h4 = new SinglyLinkedListNode(3);
const h5 = new SinglyLinkedListNode(4);
h4.next = h5;

const result = mergeLists(h1, h4);
console.log(result);
