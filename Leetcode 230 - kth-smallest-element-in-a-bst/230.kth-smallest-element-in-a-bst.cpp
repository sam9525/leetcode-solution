/*
 * @lc app=leetcode id=230 lang=cpp
 *
 * [230] Kth Smallest Element in a BST
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
  int kthSmallest(TreeNode *root, int k) {
    vector<int> tree;
    queue<TreeNode *> q;
    q.push(root);

    while (!q.empty()) {
      int len = q.size();

      while (len--) {
        TreeNode *cur = q.front();
        q.pop();

        if (cur) {
          q.push(cur->left);
          q.push(cur->right);
          tree.push_back(cur->val);
        }
      }
    }

    sort(tree.begin(), tree.end());

    return tree[k - 1];
  }
};
// @lc code=end
