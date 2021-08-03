package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 *
 * example:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 */
public class BinaryTreeLevelOrderTraversal {

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

    static List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();

      if (root == null)
          return res;

      Queue<TreeNode> current =  new ArrayDeque<>();
      Queue<TreeNode> next =  new ArrayDeque<>();

      TreeNode t = root;
      current.add(t);

      List<Integer> list = new ArrayList<>();
      while (!current.isEmpty()) {
          TreeNode n = current.poll();
          list.add(n.val);

          if (n.left != null)
              next.add(n.left);
          if (n.right != null)
              next.add(n.right);

          if (current.isEmpty()) {
              res.add(list);
              list = new ArrayList<>();
              current = next;
              next = new ArrayDeque<>();
          }
      }
      return res;
    }

    public static void main(String[] args) {
      TreeNode root = new TreeNode(3,
              new TreeNode(9), new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));

      List<List<Integer>> res = levelOrder(root);

      System.out.println(res);
    }
}
