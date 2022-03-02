package com.solutions;

public class DeleteNodeInALinkedList {

    static class ListNode {
         int val;
         ListNode next;

         ListNode(int x) { val = x; }
    }

    public static void deleteNode(ListNode node) {

        ListNode prev=null;
        ListNode cur= node;
        ListNode nextn=null;

        while(cur.next!=null)
        {
            nextn=cur.next;
            cur.val=nextn.val;
            prev=cur;
            cur=nextn;
        }

        prev.next=null;

        int a = 10;
    }

    public static void main(String[] args) {
        //[4,5,1,9]
        ListNode four = new DeleteNodeInALinkedList.ListNode(4);
        ListNode five = new DeleteNodeInALinkedList.ListNode(5);
        ListNode one = new DeleteNodeInALinkedList.ListNode(1);
        ListNode nine = new DeleteNodeInALinkedList.ListNode(9);

        five.next = one;
        one.next =nine;

        DeleteNodeInALinkedList.deleteNode(five);
    }

}
