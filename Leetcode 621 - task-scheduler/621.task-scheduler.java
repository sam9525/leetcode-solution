/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

  public int leastInterval(char[] tasks, int n) {
    // Count the frequency of each task
    Map<Character, Integer> count = new HashMap<>();
    for (char task : tasks) {
      count.put(task, count.getOrDefault(task, 0) + 1);
    }

    // Use a max heap to store the frequency of each task
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int c : count.values()) {
      pq.offer(c);
    }

    // Use a queue to store the task and the time it will be available again
    int time = 0;
    Queue<int[]> queue = new LinkedList<>();
    while (!queue.isEmpty() || !pq.isEmpty()) {
      time++;

      // If the max heap is empty, then we need to wait for the queue to be empty
      if (pq.isEmpty()) {
        time = queue.peek()[1];
      } else {
        int cur = pq.poll() - 1;

        // If the task is not finished, then add it to the queue
        if (cur > 0) {
          queue.add(new int[] { cur, time + n });
        }
      }

      // If the queue is not empty and the time is the same as the time in the queue, then add the task to the max heap
      if (!queue.isEmpty() && queue.peek()[1] == time) {
        pq.add(queue.poll()[0]);
      }
    }

    return time;
  }

  // Time Complexity: O(n log n)
  // Space Complexity: O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();

    char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
    int n = 2;
    System.out.println(solution.leastInterval(tasks, n)); // 8

    char[] tasks2 = {
      'A',
      'A',
      'A',
      'B',
      'B',
      'B',
      'C',
      'C',
      'C',
      'D',
      'D',
      'E',
    };
    int n2 = 2;
    System.out.println(solution.leastInterval(tasks2, n2)); // 12
  }
}
// @lc code=end
