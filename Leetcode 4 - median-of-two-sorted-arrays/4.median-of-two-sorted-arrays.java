/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Make sure nums1 is shorter than nums2
    if (nums1.length > nums2.length) {
      int[] temp = nums1;
      nums1 = nums2;
      nums2 = temp;
    }

    int totalLen = nums1.length + nums2.length;
    int half = (totalLen + 1) / 2;
    int left = 0, right = nums1.length;

    while (left <= right) {
      int mid1 = (right + left) / 2;
      int mid2 = half - mid1;

      int left1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
      int right1 = mid1 < nums1.length ? nums1[mid1] : Integer.MAX_VALUE;
      int left2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
      int right2 = mid2 < nums2.length ? nums2[mid2] : Integer.MAX_VALUE;

      if (left1 <= right2 && left2 <= right1) {
        if (totalLen % 2 != 0) {
          return Math.max(left1, left2);
        }
        return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
      } else if (left1 > right2) {
        right = left - 1;
      } else {
        left = left + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] nums1 = { 1, 3 };
    int[] nums2 = { 2 };
    System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // 2.0

    int[] nums3 = { 1, 2 };
    int[] nums4 = { 3, 4 };
    System.out.println(solution.findMedianSortedArrays(nums3, nums4)); // 2.5

    int[] nums5 = { 1, 2, 3, 4, 5 };
    int[] nums6 = { 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 };
    System.out.println(solution.findMedianSortedArrays(nums5, nums6)); // 9.0
  }
}
// @lc code=end
