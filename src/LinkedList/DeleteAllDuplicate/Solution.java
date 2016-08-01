package LinkedList.DeleteAllDuplicate;



/**
 * Created by namrataojha on 7/22/16.
 *
 * Problem

 Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

 For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.

 Solution

 Iterate through list, look at following node of current node to decide whether keep the curr.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode hook = new ListNode(0);
        ListNode curr = hook;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            } else {
                ListNode skip = head;
                while (skip != null && skip.val == head.val) {
                    skip = skip.next;
                }
                head = skip;
                curr.next = skip;
            }
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
        Solution s = new Solution();

        printList((s.deleteDuplicates(n1)));
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