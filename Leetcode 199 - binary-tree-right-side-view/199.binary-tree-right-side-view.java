/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return res;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int right = 0;
      int len = q.size();

      while (len > 0) {
        TreeNode cur = q.poll();

        if (cur != null) {
          if (cur.left != null) {
            q.offer(cur.left);
          }
          if (cur.right != null) {
            q.offer(cur.right);
          }
        }

        len--;
        right = cur.val;
      }

      res.add(right);
    }

    return res;
  }
}
// @lc code=end
