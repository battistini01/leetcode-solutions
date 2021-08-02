package unipd;

/**
 * Returns number of nodes having key value <= of node level on the tree.
 * Resolution of a problem given at Algorithms and data structures course exam, Computer Science UNIPD.
 *
 * @author Alberto Battistini
 * @version 0.1
 * @since 0.1
 */
public class Level {

    static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    private static int level(Node t, int level) {
        if (t == null)
            return 0;
        int l = level(t.left, level + 1);
        int r = level(t.right, level + 1);

        if (t.key <= level)
            return l + r + 1;
        return l + r;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(0);
        root.right = new Node(4);
        root.right.left = new Node(2);
        root.right.left.right = new Node(3);

        int counter = level(root, 0);
        System.out.println(counter);
    }
}
