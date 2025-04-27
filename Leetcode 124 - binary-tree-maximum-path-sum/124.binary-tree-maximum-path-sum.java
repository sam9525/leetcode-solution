/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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

  private int maxSum = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return maxSum;
  }

  private int dfs(TreeNode root) {
    if (root == null) return 0;

    // Calculate the max path sum for the left and right subtrees
    int leftMax = Math.max(0, dfs(root.left));
    int rightMax = Math.max(0, dfs(root.right));

    // Calculate the max path sum with the current root
    int sumWithRoot = root.val + leftMax + rightMax;

    // Update the max path sum
    maxSum = Math.max(maxSum, sumWithRoot);

    // Return the max path sum for the current root
    return root.val + Math.max(leftMax, rightMax);
  }
}
// @lc code=end
