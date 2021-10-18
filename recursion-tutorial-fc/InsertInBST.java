import classes.Node;

public class InsertInBST {
    
    public static Node insert(Node head, int val) {
        
        if(head == null) {

            Node newHead = new Node(val);
            return newHead;
        }

        if(head.data < val) {

            head.right = insert(head.right, val);
        }else {

            head.left = insert(head.left, val);
        }

        return head;
    }
    public static void main(String[] args) {
        
        Node h1 = new Node(100);
        h1.right = new Node(110);

        InsertInBST.insert(h1, 50);
    }
}
