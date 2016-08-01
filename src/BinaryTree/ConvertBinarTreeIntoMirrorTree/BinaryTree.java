package BinaryTree.ConvertBinarTreeIntoMirrorTree;

/**
 * Created by namrataojha on 5/27/16.
 * Write an Efficient Function to Convert a Binary Tree into its Mirror Tree
 Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right children of all non-leaf nodes interchanged.

 MirrorTree1
 code from-http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/

 //check this vedio to understand-
 https://www.youtube.com/watch?v=-EcJvzia-Ug
 */
public class BinaryTree {
    Node root;

    void mirror() {
        mirror(root);
    }

    void mirror(Node node) {
        if (node == null) {
            return;
        } else {
            Node temp;

            /* do the subtrees */
            mirror(node.left);
            mirror(node.right);

            /* swap the objects/values in this node */
            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    void inOrder() {
        inOrder(root);
    }

    /* Helper function to test mirror(). Given a binary
     search tree, print out its data elements in
     increasing sorted order.*/
    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data);

        inOrder(node.right);
    }
    /* testing for example nodes */

    public static void main(String args[]) {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        tree.inOrder();
        System.out.println("");

        /* convert tree to its mirror */
        tree.mirror();

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        tree.inOrder();

    }
}

