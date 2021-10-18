import classes.Node;
import java.util.List;

public class PrintLeafNode {
    
    public static void print(Node node) {

        if(node == null) return;

        print(node.left);
        print(node.right);

        if(node.left == null && node.right == null) {

            System.out.print(node.data + " ");
        }
    }
    public static void main(String[] args) {
        
        Node root = null;

        List<Integer> values = List.of(100, 80, 50, 90, 30, 60, 90, 85, 95, 120, 110, 108, 115, 140, 150);

        for(Integer i: values) {

            root = InsertInBST.insert(root, i);
        }
        print(root);
    }
}
