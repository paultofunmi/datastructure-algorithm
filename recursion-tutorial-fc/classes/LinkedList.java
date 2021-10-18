package classes;

public class LinkedList {
    
    public int data;
    
    public LinkedList next;

    public LinkedList(int val) {
            
        this.data = val;
    }

    public void printLinkedList() {

        LinkedList temp = this;

        while(temp != null) {
            
            if(temp.next == null) {
                System.out.println(temp.data);
            }else {
                System.out.print(temp.data + "->");
            }
            
            temp = temp.next;
        }
    }
}
