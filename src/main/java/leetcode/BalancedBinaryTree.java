package leetcode;

/**
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */

class TreeNode {
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
public class BalancedBinaryTree {

    static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        if (left && right) {
            int n_l = maxH(root.left);
            int n_r = maxH(root.right);
            return Math.abs(n_l - n_r) <= 1;
        }
        return false;
    }

    static int maxH(TreeNode n) {
        if (n == null)
            return 0;
        int l = maxH(n.left);
        int r = maxH(n.right);
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null),null),
                new TreeNode(2,null, new TreeNode(3, null, new TreeNode(4))));

         // tree: not balanced
         //                          1
         //                         / \
         //                        2   2
         //                       /     \
         //                      3       3
         //                     /         \
         //                    4           4

        System.out.println(isBalanced(tree));
    }
}
