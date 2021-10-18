package classes;

public class Node {
    
    public int data;
    
    public Node left;

    public Node right;

    public Node(int val) {
            
        this.data = val;
    }

    public void insertLeft(Node node) {

        this.left = node;
    }

    public void insertRight(Node node) {

        this.right = node;
    }
}
