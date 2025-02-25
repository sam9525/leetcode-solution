/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start

import java.util.Stack;

class Solution {

  public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;

    for (int i = 0; i <= heights.length; i++) {
      while (
        !stack.isEmpty() &&
        (i == heights.length || heights[stack.peek()] >= heights[i])
      ) {
        int height = heights[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;

        maxArea = Math.max(maxArea, height * width);
      }

      stack.push(i);
    }

    return maxArea;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] heights = { 2, 1, 5, 6, 2, 3 };
    System.out.println(solution.largestRectangleArea(heights)); // 10

    heights = new int[] { 2, 4 };
    System.out.println(solution.largestRectangleArea(heights)); // 4
  }
}
// @lc code=end
