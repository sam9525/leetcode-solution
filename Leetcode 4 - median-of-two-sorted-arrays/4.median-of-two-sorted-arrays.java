/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] merged = new int[nums1.length + nums2.length];
    int i = 0, j = 0, k = 0;

    // Merge the two sorted arrays
    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] <= nums2[j]) {
        merged[k++] = nums1[i++];
      } else {
        merged[k++] = nums2[j++];
      }
    }

    // Copy remaining elements from nums1
    while (i < nums1.length) {
      merged[k++] = nums1[i++];
    }

    // Copy remaining elements from nums2
    while (j < nums2.length) {
      merged[k++] = nums2[j++];
    }

    int mid = merged.length / 2;

    // If length is even, average the two middle elements
    if (merged.length % 2 == 0) {
      return ((double) merged[mid - 1] + merged[mid]) / 2;
    }
    // If length is odd, return middle element
    return merged[mid];
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
