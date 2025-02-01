/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();

    // Sort each string and use it as a key in the map
    for (String s : strs) {
      // Sort the string
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);

      // If map doesn't have the key, add it
      // If map has the key, add the string to the list
      map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    Solution sol = new Solution();

    System.out.println(
      sol.groupAnagrams(
        new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }
      )
    );
    System.out.println(sol.groupAnagrams(new String[] { "" }));
    System.out.println(sol.groupAnagrams(new String[] { "a" }));
  }
}
// @lc code=end
