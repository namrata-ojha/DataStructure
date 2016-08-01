package LinkedList.ReverseLinkedlistFromMtoN;

/**
 * Created by namrataojha on 7/28/16.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

 For example: given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.

 Need to see again


 */
public class Solution {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n) return head;

        ListNode prev = null;//track (m-1)th node
        ListNode first = new ListNode(0);//first's next points to mth
        ListNode second = new ListNode(0);//second's next points to (n+1)th

        int i=0;
        ListNode p = head;
        while(p!=null){
            i++;
            if(i==m-1){
                prev = p; //prev is 1>>2>>3>>4>>null
            }

            if(i==m){
                first.next = p; //first is 0>>2>>3>>4 >>null
            }

            if(i==n){
                second.next = p.next; // after 5 all are assign to second.next // second is 0>>5>>6>>null
                p.next = null; // this will asign null after 4
            }

            p= p.next;
        }
        if(first.next == null)
            return head;

        // reverse list [m, n]
        ListNode p1 = first.next;// p1 will have 2>>3>>4>>null
        ListNode p2 = p1.next; // p2 will have 3>>4>>null
        p1.next = second.next; /// p1.next will have 2>> 5>>6>> null

        while(p1!=null && p2!=null){
            ListNode t = p2.next; //t is 4>>null //t is null
            p2.next = p1; //p2 will be 3>>2>>5>>6>>null //p2 is 4>>3>>2>>5>>6>>null
            p1 = p2; // p1 will be 3>>2>>5>>6 null //p1 is 4>>3>>2>>5>>6>>null
            p2 = t; //p2 will be 4>>null //p2 is null
        }

        //connect to previous part
        if(prev!=null)
            prev.next = p1; // prev is 1 >>4>>3>>2>>5>>6
        else
            return p1;

        return head;
    }

    public static void main (String[]args)
    {
        Solution s = new Solution();
        ListNode myListNode = new ListNode(1);
        myListNode.next = new ListNode(2);
        myListNode.next.next = new ListNode(3);
        myListNode.next.next.next = new ListNode(4);
        myListNode.next.next.next.next = new ListNode(5);//so the list is 1,2,3,4,5
        myListNode.next.next.next.next.next = new ListNode(6);//so the list is 1,2,3,4,5
        myListNode.Print();//print out the list should be in order
        myListNode = reverseBetween(myListNode, 2,4);//let's rotate by 2, thus we expect 3,4,5,1,2
        myListNode.Print();//let's verify it!
//        myListNode = RotateN(myListNode, 2);//let's rotate by 2, thus we expect 5,1,2,3,4
//        myListNode.Print();//let's verify it!
    }
}

class ListNode {
    ListNode next;
    int value;

    public ListNode(int k) {
        value = k;
    }

    //we also define a print method to print ListNode in order
    public void Print() {
        ListNode current = this;
        while (current != null) {
            System.out.print(current.value + "->");
            //gosh I forget to update current index
            current = current.next;
        }
        System.out.print("NULL\n");
    }
}