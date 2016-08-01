package LinkedList.SortLinkedlist;

/**
 * Created by namrataojha on 6/20/16.
 */
class Node
{
    public int item;
    public Node next;
    public Node(int val)
    {
        item = val;
    }
    public Node()
    {}
    public void displayNode()
    {
        System.out.println("[" + item + "] ");
    }
}