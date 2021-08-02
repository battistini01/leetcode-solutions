package unipd;

/**
 * Returns number of nodes on a tree.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class N_nodes {

    static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    static int nodes(Node tree) {
        if (tree == null)
            return 0;
        int l = nodes(tree.left);
        int r = nodes(tree.right);
        return l + r + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(4);
        root.right.left = new Node(2);
        root.right.left.right = new Node(3);

        int n = nodes(root);
        System.out.println("nodes: " + n);
    }
}
