/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

  public List<Integer> partitionLabels(String s) {
    // Map store the last position of the letter
    Map<Character, Integer> last = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      last.put(cur, i);
    }

    List<Integer> result = new ArrayList<>();
    // Iterate through the string and partition whenever the current index reaches the end of the current segment
    int size = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      size++;
      end = Math.max(end, last.get(s.charAt(i)));

      if (i == end) {
        result.add(size);
        size = 0;
      }
    }
    return result;
  }

  // Time Complexity: O(n)
  // Space Complexity: O(m)

  public static void main(String[] args) {
    Solution solution = new Solution();

    List<Integer> result = solution.partitionLabels("ababcbacadefegdehijhklij");
    System.out.println(result); // [9,7,8]

    result = solution.partitionLabels("eccbbbbdec");
    System.out.println(result); // [10]
  }
}
// @lc code=end
