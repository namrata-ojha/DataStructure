package LinkedList.RemoveDuplicate;

/**
 * Created by namrataojha on 7/22/16.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class deleteDuplicates {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode hook = new ListNode(0);
        ListNode curr = hook;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
        }
        return hook.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(8);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        printList(n1);
        deleteDuplicates s = new deleteDuplicates();
        s.deleteDuplicates1(n1);
        printList(s.deleteDuplicates1(n1));
    }

    public static void printList(ListNode x) {
        if (x != null) {
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

