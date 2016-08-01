package LinkedList.partitionList;

/**
 * Created by namrataojha on 6/20/16.
 *  Partition ListNode My Submissions QuestionEditorial Solution
 Total Accepted: 69018 Total Submissions: 230397 Difficulty: Medium
 Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

 You should preserve the original relative order of the nodes in each of the two partitions.

 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.

 Subscribe to see which companies asked this question

 Solution- create two list one that has all values smaller than x and other that has all values greater than or equal to x
 finally merge them
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode curr = head;
        if (curr == null) return null;
        ListNode oldList = new ListNode(0);
        ListNode oldListCurr = oldList;
        ListNode newList = new ListNode(0);
        ListNode newListCurr = newList;
        while (curr != null) {
            if (curr.val >= x) {
                newListCurr.next = curr;
                curr = curr.next; // move the pointer to next for current
                newListCurr = newListCurr.next; // move the pointer to next for newListCurr
            } else {
                oldListCurr.next = curr;
                curr = curr.next;
                oldListCurr = oldListCurr.next;
            }
        }
        oldListCurr.next = newList.next; // concate old list to new list
        newListCurr.next = null; // assign last to null
        return oldList.next;
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
        int[] intA = {1, 4, 3, 2, 5, 2};
        ListNode in = sol.generateList(intA);
        sol.printList(in);
        sol.printList(sol.partition(in, 3));
    }
}