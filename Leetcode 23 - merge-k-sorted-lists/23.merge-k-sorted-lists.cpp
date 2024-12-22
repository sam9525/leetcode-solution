/*
 * @lc app=leetcode id=23 lang=cpp
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
  ListNode *mergeKLists(vector<ListNode *> &lists) {
    priority_queue<int, vector<int>, greater<int>> pq;
    for (ListNode *list : lists) {
      while (list) {
        pq.push(list->val);
        list = list->next;
      }
    }

    ListNode *dummy = new ListNode(0);
    ListNode *temp = dummy;

    while (!pq.empty()) {
      temp->next = new ListNode(pq.top());
      pq.pop();
      temp = temp->next;
    }

    return dummy->next;
  }
};
// @lc code=end
