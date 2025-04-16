/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> tree = new ArrayList<>();

    if (root == null) return tree;

    Queue<TreeNode> q = new LinkedList<>();

    q.offer(root);

    while (!q.isEmpty()) {
      List<Integer> curTree = new ArrayList<>();
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
          curTree.add(cur.val);
        }

        len--;
      }

      if (curTree.size() > 0) {
        tree.add(curTree);
      }
    }

    return tree;
  }
}
// @lc code=end
