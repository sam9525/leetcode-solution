/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public int[] topKFrequent(int[] nums, int k) {
    // Count the frequency of each number
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // Sort the map by value
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
    list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

    // Get the top k frequent elements
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = list.get(i).getKey();
    }

    return res;
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(
      Arrays.toString(sol.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2))
    ); // [1, 2]
    System.out.println(Arrays.toString(sol.topKFrequent(new int[] { 1 }, 1))); // [1]
  }
}
// @lc code=end
