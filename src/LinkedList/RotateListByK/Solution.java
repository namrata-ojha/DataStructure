package LinkedList.RotateListByK;

/**
 * Created by namrataojha on 7/22/16.
 * Problem

 Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 Solution
 Solution: when see  an ListNode question, recursion, two pointers  and link head and tail are always common ways to considered about.

 In this question, link head and tail is a good choice. First, use an extra reference to go from head to tail meanwhile count the
 length of this list. once we got the length and the tail , we can do two things, one is linked the tail with head,
 another is calculate k depend on given n and the length of list, k is how many nodes should be move right. k=len-n%len;
 After we finished these two things,
 we can place an preHead reference at tail and let it go next k steps, then preHead will be the point just ahead our target head.
 then return break the list here and return our target head.



 Count the length of list, break list into two lists and cat.
 */

/**
 * Please watch at http://www.youtube.com/user/ProgrammingInterview
 * Contact: haimenboy@gmail.com
 *
 * Step by step to crack programming interview questions.
 * 1. All questions were searched publicly from Google, Glassdoor, Careercup and StackOverflow.
 * 2. All codes were written from scratch and links to download the source files are provided in each video's description. All examples were written in java, and tools I have used include Editplus, Eclipse and IntelliJ.
 * 3. All videos were made without using any non-authorized material. All videos are silent sorry. Text comment is provided during coding as additional explanations.
 * Thank you very much.
 }
*/


public class Solution {
    //    public ListNode rotateRight(ListNode head, int n) {
//        if (head == null) return null;
//        ListNode curr = head;
//        int len = 1;
//        // make circular list
//        while (curr.next != null) {
//            curr = curr.next;
//            len++;
//        }
//        curr.next = head;
//        n %= len;
//        System.out.println("Value of n:"+n);
//
//        // break at required pos
//        curr = head;
//        for (int i = 0; i < len - n - 1; i++) {
//            curr = curr.next;
//        }
//        ListNode ret = curr.next;
//        curr.next = null;
//
//        return ret;
//    }
//    public void printList(ListNode e) {
//        while (e != null) {
//            System.out.format("%d ", e.val);
//            e = e.next;
//        }
//        System.out.format("\n");
//    }
//    public static void main(String[] args) {
//        Solution s = new Solution();
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        s.printList(head);
//        head = s.rotateRight(head, 2);
//        s.printList(head);
//    }
//}
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }{
        //let's create a test case
        public static void main (String[]args)
        {
            List myList = new List(1);
            myList.next = new List(2);
            myList.next.next = new List(3);
            myList.next.next.next = new List(4);
            myList.next.next.next.next = new List(5);//so the list is 1,2,3,4,5
            myList.Print();//print out the list should be in order
            myList = RotateN(myList, 2);//let's rotate by 2, thus we expect 3,4,5,1,2
            myList.Print();//let's verify it!
            myList = RotateN(myList, 2);//let's rotate by 2, thus we expect 5,1,2,3,4
            myList.Print();//let's verify it!
        }

        //all right now we implement our rotate method

    public static List RotateN(List myL, int k)//myL is the original list and k is number of rotates
    {
        //as we discussed in slide we need some variables to keep track of
        //1. the tail of final list, or Kth value
        //2. the head of final list, or k+1th node
        //3. we need a current visiting node to keep track of visiting status all the time
        List current = myL;//we start from my list head
        List oldTail;
        List newStart;
        //firstly we try to find the tail of kth value
        while (k > 1)//notice we use 1 instead of 0
        {
            current = current.next;
            k--;
        }
        //now the current points to kth value, and the new list's head is its next!
        newStart = current.next;
        //also as the currentNode is the final tail, we need to set its next to null
        current.next = null;
        //next we proceed from the newStart until end (tail of original list) and set the next of tail to myL!!!
        current = newStart;//we update our current by one step further
        while (current.next != null)
            current = current.next;
        //now we come to the tail of original ListNode, current keeps track of it
        current.next = myL;//myL is the head of original ListNode!
        //finally we return the list starting from newStart
        return newStart;
    }
}

//we firstly define our simple ListNode class
class List {
    List next;
    int value;

    public List(int k) {
        value = k;
    }

    //we also define a print method to print ListNode in order
    public void Print() {
        List current = this;
        while (current != null) {
            System.out.print(current.value + "->");
            //gosh I forget to update current index
            current = current.next;
        }
        System.out.print("NULL\n");
    }
}



