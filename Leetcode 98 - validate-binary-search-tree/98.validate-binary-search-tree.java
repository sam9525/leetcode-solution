/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

  public boolean isValidBST(TreeNode root) {
    return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  // Min and max are the range of the values of the nodes in the tree
  // At the beginning, the range is the entire range of the integer values
  // As we traverse to the left, the max value is its further parent's value on the left side
  // As we traverse to the right, the min value is its further parent's value on the right side
  private boolean dfs(TreeNode root, long min, long max) {
    if (root == null) return true;

    if (!(root.val < max && root.val > min)) {
      return false;
    }

    return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
  }
}
// @lc code=end
