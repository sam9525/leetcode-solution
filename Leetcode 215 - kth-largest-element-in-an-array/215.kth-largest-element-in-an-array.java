/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start

import java.util.PriorityQueue;

class Solution {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    return pq.peek();
  }

  // Time Complexity: O(n log k)
  // Space Complexity: O(k)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 3, 2, 1, 5, 6, 4 };
    int k = 2;
    System.out.println(solution.findKthLargest(nums, k)); // 5

    int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k2 = 4;
    System.out.println(solution.findKthLargest(nums2, k2)); // 4
  }
}
// @lc code=end
