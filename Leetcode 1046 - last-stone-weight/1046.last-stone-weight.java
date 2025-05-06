/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

  public int lastStoneWeight(int[] stones) {
    // Store the value in reverse order (large to small)
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    // Add all stones in to priority queue
    for (int stone : stones) {
      pq.add(stone);
    }

    // While there are more than 1 stone in the priority queue
    while (pq.size() > 1) {
      int y = pq.poll();
      int x = pq.poll();

      // If the two stones are the same, do nothing
      if (x == y) {
        continue;
      } else {
        // If the two stones are different, subtract the smaller from the larger and add the result to the priority queue
        pq.add(y - x);
      }
    }

    return pq.peek();
  }

  // Time Complexity : O(n log n)
  // Space Complexity : O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(
      solution.lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 })
    ); // 1
    System.out.println(solution.lastStoneWeight(new int[] { 1 })); // 1
  }
}
// @lc code=end
