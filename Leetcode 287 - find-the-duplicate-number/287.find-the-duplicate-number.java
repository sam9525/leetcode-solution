/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start

import java.util.HashSet;

class Solution {

  public int findDuplicate(int[] nums) {
    HashSet<Integer> number = new HashSet<>();

    for (int num : nums) {
      if (!number.contains(num)) {
        number.add(num);
      } else {
        return num;
      }
    }

    return -1;
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
