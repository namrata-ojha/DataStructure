package BinaryTree.SortedLinkedListToBalancedBST;

/**
 * Created by namrataojha on 8/1/16.
 *Question-
 * Sorted Linked List to Balanced BST
 Given a Singly Linked List which has data members sorted in ascending order.
 Construct a Balanced Binary Search Tree which has same data members as the given Linked List.


 *
 * Solution-
 * The method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root.
 * The idea is to insert nodes in BST in the same order as the appear in Linked List,
 * so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List.
 * Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree.
 * After left subtree is constructed, we allocate memory for root and link the left subtree with root.
 * Finally, we recursively construct the right subtree and link it with root.
 While constructing the BST, we also keep moving the list h pointer to next
 so that we have the appropriate pointer in each recursive call.
 Following is C implementation of method 2. The main code which creates Balanced BST is highlighted.
 Little difficult to understand
 */
class LinkedList {

    /* h node of link list */
    static LNode head;

    /* Link list Node */
    class LNode
    {
        int data;
        LNode next, prev;

        LNode(int d)
        {
            data = d;
            next = prev = null;
        }
    }

    /* A Binary Tree Node */
    class TNode
    {
        int data;
        TNode left, right;

        TNode(int d)
        {
            data = d;
            left = right = null;
        }
    }

    /* This function counts the number of nodes in Linked List
       and then calls sortedListToBSTRecur() to construct BST */
    TNode sortedListToBST()
    {
        /*Count the number of nodes in Linked List */
        int n = countNodes(head);

        /* Construct BST */
        return sortedListToBSTRecur(n);
    }

    /* The main function that constructs balanced BST and
       returns root of it.
       n  --> No. of nodes in the Doubly Linked List */
    TNode sortedListToBSTRecur(int n)
    {
        /* Base Case */
        if (n <= 0)
            return null;

        /* Recursively construct the left subtree */
        TNode left = sortedListToBSTRecur(n / 2);

        /* head_ref now refers to middle node,
           make middle node as root of BST*/
        TNode root = new TNode(head.data);

        // Set pointer to left subtree
        root.left = left;

        /* Change h pointer of Linked List for parent
           recursive calls */
        head = head.next;

        /* Recursively construct the right subtree and link it
           with root. The number of nodes in right subtree  is
           total nodes - nodes in left subtree - 1 (for root) */
        root.right = sortedListToBSTRecur(n - n / 2 - 1);

        return root;
    }

    /* UTILITY FUNCTIONS */
    /* A utility function that returns count of nodes in a
       given Linked List */
    int countNodes(LNode head)
    {
        int count = 0;
        LNode temp = head;
        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    /* Function to insert a node at the beginging of
       the Doubly Linked List */
    void push(int new_data)
    {
        /* allocate node */
        LNode new_node = new LNode(new_data);

        /* since we are adding at the begining,
           prev is always NULL */
        new_node.prev = null;

        /* link the old list off the new node */
        new_node.next = head;

        /* change prev of h node to new node */
        if (head != null)
            head.prev = new_node;

        /* move the h to point to the new node */
        head = new_node;
    }

    /* Function to print nodes in a given linked list */
    void printList(LNode node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    /* A utility function to print preorder traversal of BST */
    void preOrder(TNode node)
    {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /* Drier program to test above functions */
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

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
        llist.printList(head);

        /* Convert List to BST */
        TNode root = llist.sortedListToBST();
        System.out.println("");
        System.out.println("Pre-Order Traversal of constructed BST ");
        llist.preOrder(root);
    }
}
