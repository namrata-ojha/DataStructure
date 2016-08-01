package LinkedList.OddEvenLinkedList;

/**
 * Created by namrataojha on 5/17/16.
 */
public class LinkedList {
    static Node head1 ,evenHead,oddHead;
    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    LinkedList oddEvenLinkedList(){
//
//// if ‘current’ is even node:
//        Node lastEven ;
//        Node current ;
//        if (evenHead == null){
//            evenHead = lastEven ;
//            lastEven  = current;
//        }
//        else {
//            lastEven.next = current;
//            lastEven = current;
//        }
//
//// if ‘current’ is odd node:
//        Node lastOdd = null;
//        Node head;
//        if (oddHead == null){
//            oddHead = lastOdd = current;
//        }
//        else {
//            lastOdd.next = current;
//            lastOdd = current;
//        }
//
//        if (evenHead != null){
//            head = evenHead;
//        }
//
//        if (lastEven != null){
//            lastEven.next = oddHead;
//        }
//
//        if (lastOdd != null){
//            lastOdd.next = null;
//        }
//
        return null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // creating first linked list
        list.head1 = new Node(1);
        list.head1.next = new Node(2);
        list.head1.next.next = new Node(3);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(5);

//        // creating second linked list
//        list.head2 = new IntersectionPointOfLinkedList.LinkedList.Node(10);
//        list.head2.next = new IntersectionPointOfLinkedList.LinkedList.Node(15);
//        list.head2.next.next = new IntersectionPointOfLinkedList.LinkedList.Node(30);

        //System.out.println("The node of intersection is " + list.getNode());

    }


}
