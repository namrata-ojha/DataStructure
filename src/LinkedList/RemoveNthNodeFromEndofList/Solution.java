package LinkedList.RemoveNthNodeFromEndofList;

/**
 * Created by namrataojha on 6/20/16.
 * Given a linked list, remove the nth node from the end of list and return its head.

 For example,

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 Note:
 Given n will always be valid.
 Try to do this in one pass.


 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hook = new ListNode(0); // need this if remove the head node
        hook.next = head;
        ListNode curr = hook, prev;
        for (int i = 0; i <= n; i++) {
            curr = curr.next;
        }
        prev = hook;
        while (curr != null) {
            curr = curr.next;
            prev = prev.next; // y this is necessary ?
        }
        prev.next = prev.next.next; // y this is necessary ?
        return hook.next;
    }
    public ListNode generateList(int[] list) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i : list) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        return head.next;
    }
    public void printList(ListNode e) {
        while (e != null) {
            System.out.format("%d\t", e.val);
            e = e.next;
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] intA = {1, 2, 3, 4, 5};
        ListNode in = sol.generateList(intA);
        sol.printList(in);
        sol.printList(sol.removeNthFromEnd(in, 3));
    }
}