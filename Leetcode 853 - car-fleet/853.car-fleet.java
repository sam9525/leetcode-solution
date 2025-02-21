/*
 * @lc app=leetcode id=853 lang=java
 *
 * [853] Car Fleet
 */

// @lc code=start

class Solution {

  public int carFleet(int target, int[] position, int[] speed) {
    double[] times = new double[target + 1];

    for (int i = 0; i < position.length; i++) {
      times[position[i]] = (double) (target - position[i]) / speed[i];
    }

    int fleets = 0;
    double maxTime = 0;

    for (int i = target; i >= 0; i--) {
      if (times[i] > 0) {
        if (times[i] > maxTime) {
          fleets++;
          maxTime = times[i];
        }
      }
    }

    return fleets;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int target = 12;
    int[] position = { 10, 8, 0, 5, 3 };
    int[] speed = { 2, 4, 1, 1, 3 };
    System.out.println(solution.carFleet(target, position, speed)); // 3

    target = 10;
    position = new int[] { 3 };
    speed = new int[] { 3 };
    System.out.println(solution.carFleet(target, position, speed)); // 1

    target = 100;
    position = new int[] { 0, 2, 4 };
    speed = new int[] { 4, 2, 1 };
    System.out.println(solution.carFleet(target, position, speed)); // 1

    target = 10;
    position = new int[] { 6, 8 };
    speed = new int[] { 3, 2 };
    System.out.println(solution.carFleet(target, position, speed)); // 2
  }
}
// @lc code=end
