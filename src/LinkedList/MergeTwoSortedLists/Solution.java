package LinkedList.MergeTwoSortedLists;

import java.util.ArrayList;

/**
 * Created by namrataojha on 6/20/16.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.


 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newList = new ListNode(0);
        ListNode curr = newList;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = l2;
                break;
            }
            if (l2 == null) {
                curr.next = l1;
                break;
            }
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        return newList.next;
    }
    public void printList(ListNode e) {
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(2);
        Solution s = new Solution();
        ArrayList<ListNode> lists = new ArrayList<ListNode>();
        lists.add(l1);
        lists.add(l2);
        ListNode res = s.mergeTwoLists(l1, l2);
        s.printList(res);
    }
}