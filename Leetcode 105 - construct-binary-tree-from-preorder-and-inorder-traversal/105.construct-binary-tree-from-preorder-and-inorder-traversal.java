/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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

  int preorderIdx = 0;
  Map<Integer, Integer> nodes = new HashMap<>();

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Put every nodes from inorder into map
    for (int i = 0; i < inorder.length; i++) {
      nodes.put(inorder[i], i);
    }

    return dfs(preorder, 0, inorder.length);
  }

  private TreeNode dfs(int[] preorder, int left, int right) {
    // When left greater than right, means there is no more childs under the node
    if (left > right) return null;

    int rootVal = preorder[preorderIdx++];

    TreeNode root = new TreeNode(rootVal);

    // Find the root in the inorder map
    // Left side of the root is the left subtree, right side of the root is the right subtree
    int mid = nodes.get(rootVal);

    // Recursively build the left and right subtrees
    root.left = dfs(preorder, left, mid - 1);
    root.right = dfs(preorder, mid + 1, right);

    return root;
  }
}
// @lc code=end
