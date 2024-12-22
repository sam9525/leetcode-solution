/*
 * @lc app=leetcode id=347 lang=cpp
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> topKFrequent(vector<int> &nums, int k) {
    priority_queue<pair<int, int>> pq;
    unordered_map<int, int> freq;

    for (int num : nums) {
      freq[num]++;
    }

    for (auto &entry : freq) {
      pq.push({entry.second, entry.first});
    }

    vector<int> result;
    for (int i = 0; i < k; i++) {
      result.push_back(pq.top().second);
      pq.pop();
    }

    return result;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 1, 1, 2, 2, 3};
  int k = 2;
  vector<int> result = sol.topKFrequent(nums, k);
  for (int num : result) {
    cout << num << " ";
  } // 1 2

  cout << endl;

  nums = {1};
  k = 1;
  result = sol.topKFrequent(nums, k);
  for (int num : result) {
    cout << num << " ";
  } // 1
}
// @lc code=end
