/*
 * @lc app=leetcode id=83 lang=cpp
 *
 * [83] Remove Duplicates from Sorted List
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
#include <iostream>

using namespace std;

class Solution {
public:
  ListNode *deleteDuplicates(ListNode *head) {
    ListNode *cur = head;
    while (cur && cur->next) {
      if (cur->val == cur->next->val) {
        cur->next = cur->next->next;
      } else {
        cur = cur->next;
      }
    }
    return head;
  }
};
// @lc code=end
