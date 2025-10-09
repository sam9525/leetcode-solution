/*
 * @lc app=leetcode id=1899 lang=java
 *
 * [1899] Merge Triplets to Form Target Triplet
 */

// @lc code=start
class Solution {

  public boolean mergeTriplets(int[][] triplets, int[] target) {
    boolean x = false, y = false, z = false;

    // Verify that the target element exists in the triplets and ensure no other elements in the same triplet exceed the target's values
    for (int[] triplet : triplets) {
      x |=
        (
          triplet[0] == target[0] &&
          triplet[1] <= target[1] &&
          triplet[2] <= target[2]
        );
      y |=
        (
          triplet[0] <= target[0] &&
          triplet[1] == target[1] &&
          triplet[2] <= target[2]
        );
      z |=
        (
          triplet[0] <= target[0] &&
          triplet[1] <= target[1] &&
          triplet[2] == target[2]
        );

      if (x && y && z) return true;
    }

    return false;
  }

  // Time Complexity: O(n)
  // Space Complexity: O(1)

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[][] triplets = new int[][] { { 2, 5, 3 }, { 1, 7, 5 } };
    int[] target = new int[] { 2, 7, 5 };
    System.out.println(solution.mergeTriplets(triplets, target)); // true

    triplets = new int[][] { { 3, 4, 5 }, { 4, 5, 6 } };
    target = new int[] { 3, 5, 7 };
    System.out.println(solution.mergeTriplets(triplets, target)); // false

    triplets =
      new int[][] { { 2, 5, 3 }, { 2, 3, 7 }, { 3, 4, 7 }, { 3, 8, 6 } };
    target = new int[] { 3, 8, 7 };
    System.out.println(solution.mergeTriplets(triplets, target)); // true
  }
}
// @lc code=end
