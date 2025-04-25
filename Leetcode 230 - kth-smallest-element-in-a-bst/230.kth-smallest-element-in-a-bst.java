/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

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

  // According to the definition of a BST, using dfs, the smallest element of the tree will be first put inside the list
  // So we can just return the kth element in the inorder traversal
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> inorder = new ArrayList<>();

    dfs(root, inorder);

    return inorder.get(k - 1);
  }

  private void dfs(TreeNode root, List<Integer> inorder) {
    if (root == null) return;

    dfs(root.left, inorder);

    inorder.add(root.val);

    dfs(root.right, inorder);
  }
}
// @lc code=end
