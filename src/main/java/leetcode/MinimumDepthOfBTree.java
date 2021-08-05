package leetcode;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBTree {

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return calculatemin(root, 1);
    }

    static int calculatemin(TreeNode t, int n) {
        if (t.left == null && t.right == null) { // leaf
            return n;
        }
        if (t.left == null)
            return calculatemin(t.right, n+1);
        else if (t.right == null)
            return calculatemin(t.left, n+1);
        else {
            return Math.min(calculatemin(t.left, n+1), calculatemin(t.right, n+1));
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null,
                new TreeNode(5, null, new TreeNode(6)))));

        System.out.println(minDepth(tree));
    }
}
