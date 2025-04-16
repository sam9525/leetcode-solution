/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start

class Solution {

  public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];

    // Find the cycle
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    // Reset slow
    slow = nums[0];

    // If they meet again, the number is a duplicate
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums = { 1, 3, 4, 2, 2 };
    System.out.println(solution.findDuplicate(nums)); // 2

    nums = new int[] { 3, 1, 3, 4, 2 };
    System.out.println(solution.findDuplicate(nums)); // 3

    nums = new int[] { 3, 3, 3, 3, 3 };
    System.out.println(solution.findDuplicate(nums)); // 3
  }
}
// @lc code=end
