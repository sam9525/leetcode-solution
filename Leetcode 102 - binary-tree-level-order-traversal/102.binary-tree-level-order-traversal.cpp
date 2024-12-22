/*
 * @lc app=leetcode id=102 lang=cpp
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
  vector<vector<int>> levelOrder(TreeNode *root) {
    vector<vector<int>> tree;

    if (root == NULL)
      return tree;

    queue<TreeNode *> q;

    q.push(root);

    while (!q.empty()) {
      int len = q.size();
      vector<int> curTree;

      for (int i = 0; i < len; i++) {
        TreeNode *cur = q.front();
        q.pop();

        if (cur->left)
          q.push(cur->left);
        if (cur->right)
          q.push(cur->right);

        curTree.push_back(cur->val);
      }

      tree.push_back(curTree);
    }

    return tree;
  }
};
// @lc code=end
