/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    // Find the middle of the Linked List, using Tortoise and Hare algorithm
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // Reverse the second half
    ListNode second = getReverse(slow);

    // Merge two List
    ListNode first = head;

    while (second.next != null) {
      ListNode firstNext = first.next;
      ListNode secondNext = second.next;

      first.next = second;
      second.next = firstNext;

      first = firstNext;
      second = secondNext;
    }
  }

  public ListNode getReverse(ListNode head) {
    ListNode cur = head;
    ListNode prev = null;

    while (cur != null) {
      ListNode temp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = temp;
    }

    return prev;
  }
}
// @lc code=end
