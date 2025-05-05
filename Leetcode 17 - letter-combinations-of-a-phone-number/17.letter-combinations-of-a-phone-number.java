/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

  private List<String> result = new ArrayList<>();
  private String[] digitToChar = {
    "",
    "",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz",
  };

  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return result;

    backtrack(digits, new StringBuilder(), 0);
    return result;
  }

  private void backtrack(String digits, StringBuilder curStr, int cur) {
    if (curStr.length() == digits.length()) {
      result.add(curStr.toString());
      return;
    }

    String chars = digitToChar[digits.charAt(cur) - '0'];
    for (char c : chars.toCharArray()) {
      curStr.append(c);
      backtrack(digits, curStr, cur + 1);
      curStr.deleteCharAt(curStr.length() - 1);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    for (String s : solution.letterCombinations("23")) {
      System.out.println(s);
    } // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    for (String s : solution.letterCombinations("")) {
      System.out.println(s);
    } // []
  }
}
// @lc code=end
