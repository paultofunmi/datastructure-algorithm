import classes.LinkedList;

public class MergeSortedLinkedList {
    
    public static LinkedList merge2(LinkedList l1, LinkedList l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.data < l2.data) { 
         
            l1.next = merge2(l1.next, l2);
            return l1;
        }
        else { 
            
            l2.next = merge2(l1, l2.next);
            return l2;
        }
    }

    public static LinkedList merge1(LinkedList l1, LinkedList l2) {

        LinkedList result = null;
        
        while(l1 != null && l2 != null) {
            
            if(l1.data < l2.data) {

                result = setLinkedList(l1.data, result);
                l1 = l1.next;
            }else if(l1.data > l2.data) {

                result = setLinkedList(l2.data, result);
                l2 = l2.next;
            }else {

                result = setLinkedList(l1.data, result);
                l1 = l1.next;

                result = setLinkedList(l2.data, result);
                l2 = l2.next;
            }

        }

        while(l1 != null) {

            result = setLinkedList(l1.data, result);
            l1 = l1.next;
        }

        while(l2 != null) {

            result = setLinkedList(l2.data, result);
            l2 = l2.next;
        }

        return result;
    }

    private static LinkedList setLinkedList(int data, LinkedList result) {

        LinkedList newLL = new LinkedList(data);
        LinkedList temp = result;

        if(temp == null) result = newLL;
        else {

            while (temp.next != null) {
                
                temp = temp.next;
            }

            temp.next = newLL;
        }

        return result;
    }

    public static void main(String[] args) {
        
        LinkedList n2 = new LinkedList(2);
        LinkedList n4 = new LinkedList(4);
        LinkedList n6 = new LinkedList(6);
        LinkedList n61 = new LinkedList(6);

        n2.next = n4;
        n4.next = n6;
        n6.next = n61;

        LinkedList n1 = new LinkedList(1);
        LinkedList n3 = new LinkedList(3);
        LinkedList n5 = new LinkedList(5);

        n1.next = n3;
        n3.next = n5;

        LinkedList result = merge1(n2, n1);
        result.printLinkedList();
        LinkedList result1 = merge2(n2, n1);
        result1.printLinkedList();
    }
}
