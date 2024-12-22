/*
 * @lc app=leetcode id=215 lang=cpp
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  int findKthLargest(vector<int> &nums, int k) {
    return quickSelect(nums, 0, nums.size() - 1, k - 1);
  }

  int quickSelect(vector<int> &nums, int left, int right, int k) {
    if (left == right) {
      return nums[left];
    }

    int p = partition(nums, left, right);
    if (k == p) {
      return nums[k];
    } else if (k < p) {
      return quickSelect(nums, left, p - 1, k);
    } else {
      return quickSelect(nums, p + 1, right, k);
    }
  }

  int partition(vector<int> &nums, int left, int right) {
    int pivot = nums[right];

    int i = left - 1;
    for (int j = left; j < right; j++) {
      if (nums[j] >= pivot) {
        i++;
        swap(nums, i, j);
      }
    }

    swap(nums, i + 1, right);

    return i + 1;
  }

  void swap(vector<int> &nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {3, 2, 1, 5, 6, 4};
  int k = 2;
  cout << sol.findKthLargest(nums, k) << endl; // 5

  nums = {3, 3, 3, 3, 3, 3};
  k = 2;
  cout << sol.findKthLargest(nums, k) << endl; // 3
}
// @lc code=end
