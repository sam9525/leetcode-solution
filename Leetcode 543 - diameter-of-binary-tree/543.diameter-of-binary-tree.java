/*
 * @lc app=leetcode id=543 lang=java
 *
 * [543] Diameter of Binary Tree
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

  int maxDiameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    maxDepth(root);

    return maxDiameter;
  }

  public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

    return Math.max(leftDepth, rightDepth) + 1;
  }
}
// @lc code=end
