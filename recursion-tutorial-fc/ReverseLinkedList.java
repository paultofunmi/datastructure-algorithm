import classes.LinkedList;

public class ReverseLinkedList {

    public static void main(String[] args) {
        
        LinkedList n1 = new LinkedList(1);
        LinkedList n2 = new LinkedList(2);
        LinkedList n3 = new LinkedList(3);
        LinkedList n4 = new LinkedList(4);
        LinkedList n5 = new LinkedList(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.printLinkedList();
        LinkedList result = ReverseLinkedList.reverse(n1);
        result.printLinkedList();
    }

    public static LinkedList reverse(LinkedList head) {

        if(head == null || head.next == null) return head;

        LinkedList newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
