package LinkedList.SortLinkedlist;

/**
 * Created by namrataojha on 6/20/16.
 *  * Problem
 *
 * https://www.youtube.com/watch?v=jOyYaBHyN28
 Sort a linked list in O(n log n) time using constant space complexity.

 */
class LinkedList
{
    private Node first;
    public LinkedList()
    {
        first = null;
    }
    public boolean isEmpty()
    {
        return (first==null);
    }
    public void insert(int val)//inserts at beginning of list
    {
        Node newNode = new Node(val);
        newNode.next = first;
        first = newNode;
    }
    public void append(Node result)
    {
        first = result;
    }
    public void display()
    {
        System.out.println("ListNode items from first to last :");
        Node current = first;
        while(current != null)
        {
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }
    public Node extractFirst()
    {
        return first;
    }
    public Node MergeSort(Node headOriginal)
    {
        if (headOriginal == null || headOriginal.next == null)
            return headOriginal;
        Node a = headOriginal;
        Node b = headOriginal.next;
        while ((b != null) && (b.next != null))
        {
            headOriginal = headOriginal.next;
            b = (b.next).next;
        }
        b = headOriginal.next;
        headOriginal.next = null;
        return merge(MergeSort(a), MergeSort(b));

    }

    public Node merge(Node a, Node b)
    {
        Node temp = new Node();
        Node head = temp;
        Node c = head;
        while ((a != null) && (b != null))
        {
            if (a.item <= b.item)
            {
                c.next = a;
                c = a;
                a = a.next;
            }
            else
            {
                c.next = b;
                c = b;
                b = b.next;
            }
        }
        c.next = (a == null) ? b : a;
        return head.next;
    }
}

class LinkedListBlog
{
    public static void main(String[] args)
    {
        LinkedList object = new LinkedList();
        object.insert(30);
        object.insert(10);
        object.insert(50);
        object.insert(20);
        object.insert(5);
        object.insert(8);
        object.display();
        System.out.println("The list after merge sort O(nlog(n))");
        object.append(object.MergeSort(object.extractFirst()));
        object.display();
    }
}