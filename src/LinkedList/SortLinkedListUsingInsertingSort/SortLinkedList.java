package LinkedList.SortLinkedListUsingInsertingSort;

/**
 * Created by namrataojha on 7/21/16.
 */
public class SortLinkedList {
    //Difficult to understand this method
//    public static ListNode insertionSortList(ListNode head) {
//
//        if (head == null || head.next == null)
//            return head;
//
//        ListNode newHead = new ListNode(head.val);
//        ListNode pointer = head.next;
//
//        // loop through each element in the list
//        while (pointer != null) {
//            // insert this element to the new list
//
//            ListNode innerPointer = newHead;
//            ListNode next = pointer.next;
//
//            if (pointer.val <= newHead.val) {
//                ListNode oldHead = newHead;
//                newHead = pointer;
//                newHead.next = oldHead;
//            } else {
//                while (innerPointer.next != null) {
//
//                    if (pointer.val > innerPointer.val && pointer.val <= innerPointer.next.val) {
//                        ListNode oldNext = innerPointer.next;
//                        innerPointer.next = pointer;
//                        pointer.next = oldNext;
//                    }
//
//                    innerPointer = innerPointer.next;
//                }
//
//                if (innerPointer.next == null && pointer.val > innerPointer.val) {
//                    innerPointer.next = pointer;
//                    pointer.next = null;
//                }
//            }
//
//            // finally
//            pointer = next;
//        }
//
//        return newHead;
//    }

    // find the number not in order and then compare that number to all the left numbers and place the number to its right position and make link with the
    // with the number previous to it to next of it .
    // eg- if numbers are 2,3,4,0,6,5
    //step one -compare 2 and 3 - they are ok
    //comapre 3 and 4 - they are ok -
    // compare 4and 0 - 0 is smaller than 4
    // so comapre 0 to 2, 3,4 and find its right position i.e - before 2
  //  place it before 2
    // and make link from 4 to 6 so o/p- will be 0,2,3,4,6,5
    // repeat the cycle till the end
    // in next cycle 6 is not in  place
public static ListNode insertionSortList(ListNode head) {
    if (head==null ||head.next==null){
        return head;
    }

    ListNode preHead=new ListNode (-1);

    preHead.next=head;
    ListNode run=head;


    while (run!=null && run.next!=null){

        if (run.val>run.next.val){
            // find node which is not in order
            ListNode smallNode=run.next;

            ListNode pre=preHead;

            // find position for smallNode
            while (pre.next.val<smallNode.val){
                pre=pre.next;
            }


            ListNode temp=pre.next;
            pre.next=smallNode;

            run.next=smallNode.next;
            smallNode.next=temp;

        }
        else{
            // node is in order
            run=run.next;

        }

    }

    return preHead.next;

}
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(0);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = insertionSortList(n1);

        printList(n1);

    }

    public static void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }
}
