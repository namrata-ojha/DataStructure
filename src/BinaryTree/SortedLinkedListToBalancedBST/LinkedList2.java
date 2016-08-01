package BinaryTree.SortedLinkedListToBalancedBST;

/**
 * Created by namrataojha on 8/1/16.
 * Same solution but in easier way
 */
public class LinkedList2 {

    static ListNode h;

    /* Link list Node */
    class ListNode
    {
        int data;
        ListNode next, prev;

        ListNode(int d)
        {
            data = d;
            next = prev = null;
        }
    }

    /* A Binary Tree Node */
    class TreeNode
    {
        int data;
        TreeNode left, right;

        TreeNode(int d)
        {
            data = d;
            left = right = null;
        }
    }





    //static ListNode h;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }

    // get list length
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    // build tree bottom-up
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end) //0 to 6 //0 To 2 //0 to 0 //0 to -1
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1); //sortedListToBST(0, 3)//sortedListToBST(0, 1)//sortedListToBST(0, 0)//sortedListToBST(0, -1)
        TreeNode root = new TreeNode(h.data); //1 //2
        h = h.next; //2
        TreeNode right = sortedListToBST(mid + 1, end); //0+1 to 0 returns null

        root.left = left; //null
        root.right = right; //null

        return root;
    }


    void push(int new_data)
    {
        /* allocate node */
        ListNode new_node = new ListNode(new_data);

        /* since we are adding at the begining,
           prev is always NULL */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = h;

        /* change prev of h node to new node */
        if (h != null)
            h.prev = new_node;

        /* move the h to point to the new node */
        h = new_node;
    }

    /* Function to print nodes in a given linked list */
    void printList(ListNode node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /* Drier program to test above functions */
    public static void main(String[] args) {
        LinkedList2 llist = new LinkedList2();

        /* Let us create a sorted linked list to test the functions
           Created linked list will be 7->6->5->4->3->2->1 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Given Linked List ");
        llist.printList(h);

        /* Convert List to BST */
        TreeNode root = llist.sortedListToBST(h);
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
    }
}
