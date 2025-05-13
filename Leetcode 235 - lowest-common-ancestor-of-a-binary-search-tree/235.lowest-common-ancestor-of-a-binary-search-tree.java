/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

  // In LCA root.left < root.val, root.right > root.val
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      // Case 1: p and q are both on the left side of the root
      if (root.val < p.val && root.val < q.val) {
        root = root.right;
        // Case 2: p and q are both on the right side of the root
      } else if (root.val > p.val && root.val > q.val) {
        root = root.left;
        // Case 3: p and q are on different sides of the root
      } else {
        return root;
      }
    }

    return null;
  }
  // Time Complexity: O(n)
  // Space Complexity: O(1)
}
// @lc code=end
