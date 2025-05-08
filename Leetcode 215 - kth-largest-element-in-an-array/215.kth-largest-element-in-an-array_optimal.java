/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start

class Solution {

  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  private int quickSelect(int[] nums, int left, int right, int k) {
    // Divide and Conquer
    // Choose the last element as pivot
    int pivot = nums[right];

    int i = left - 1;

    // Partitioning
    for (int j = left; j < right; j++) {
      // If the current element is less than or equal to the pivot, swap it with the element at index i
      if (nums[j] <= pivot) {
        i++;
        swap(nums, i, j);
      }
    }

    // Swap the pivot element with the element at index i + 1
    swap(nums, i + 1, right);

    // If the index of the pivot is greater than k, then the kth largest element is in the left subarray
    if (i > k) {
      return quickSelect(nums, left, i - 1, k);
    } else if (i < k) {
      // If the index of the pivot is less than k, then the kth largest element is in the right subarray
      return quickSelect(nums, i + 1, right, k);
    } else {
      // If the index of the pivot is equal to k, then the pivot is the kth largest element
      return nums[i];
    }
  }

  private void swap(int[] nums, int left, int pivotIdx) {
    int temp = nums[left];
    nums[left] = nums[pivotIdx];
    nums[pivotIdx] = temp;
  }

  // Time Complexity : O(n)
  // Space Complexity : O(n)

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums = { 3, 2, 1, 5, 6, 4 };
    int k = 2;
    System.out.println(solution.findKthLargest(nums, k)); // 5

    int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k2 = 4;
    System.out.println(solution.findKthLargest(nums2, k2)); // 4
  }
}
// @lc code=end
