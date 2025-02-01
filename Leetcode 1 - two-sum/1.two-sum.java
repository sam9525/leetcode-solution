/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

import java.util.HashMap;

class Solution {

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();

    // Check all the numbers in the array
    for (int i = 0; i < nums.length; i++) {
      int remain = target - nums[i];
      // Check if the remain is in the map
      if (map.containsKey(remain)) {
        return new int[] { map.get(remain), i };
      }
      // If the remain is not in the map, put the number and its index in the map
      map.put(nums[i], i);
    }

    return new int[] {};
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    int[] result1 = sol.twoSum(new int[] { 2, 7, 11, 15 }, 9);
    System.out.println("[" + result1[0] + ", " + result1[1] + "]"); // [0, 1]
    int[] result2 = sol.twoSum(new int[] { 3, 2, 4 }, 6);
    System.out.println("[" + result2[0] + ", " + result2[1] + "]"); // [1, 2]
    int[] result3 = sol.twoSum(new int[] { 3, 3 }, 6);
    System.out.println("[" + result3[0] + ", " + result3[1] + "]"); // [0, 1]
  }
}
// @lc code=end
