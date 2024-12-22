/*
 * @lc app=leetcode id=530 lang=cpp
 *
 * [530] Minimum Absolute Difference in BST
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
  vector<int> nums;

  int getMinimumDifference(TreeNode *root) {
    inorder(root); // Remove nums parameter

    int minDiff = INT_MAX;
    for (int i = 1; i < nums.size(); i++) {
      minDiff = min(minDiff, nums[i] - nums[i - 1]);
    }
    return minDiff;
  }

  void inorder(TreeNode *root) { // Remove nums parameter
    if (!root)
      return;

    inorder(root->left);
    nums.push_back(root->val);
    inorder(root->right);
  }
};
// @lc code=end
