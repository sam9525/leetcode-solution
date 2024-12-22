/*
 * @lc app=leetcode id=167 lang=cpp
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> twoSum(vector<int> &numbers, int target) {
    int left = 0;
    int right = numbers.size() - 1;

    while (left < right) {
      int sum = numbers[left] + numbers[right];

      if (sum == target)
        return {left + 1, right + 1};
      sum = sum > target ? right-- : left++;
    }

    return {};
  }
};

int main() {
  Solution sol;
  vector<int> numbers = {2, 7, 11, 15}; // 1 2
  int target = 9;
  vector<int> res = sol.twoSum(numbers, target);
  for (int num : res) {
    cout << num << " ";
  }
  cout << endl;

  vector<int> numbers2 = {2, 3, 4}; // 1 3
  int target2 = 6;
  vector<int> res2 = sol.twoSum(numbers2, target2);
  for (int num : res2) {
    cout << num << " ";
  }
  cout << endl;
}
// @lc code=end
