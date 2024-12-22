/*
 * @lc app=leetcode id=1046 lang=cpp
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
#include <iostream>
#include <queue>
#include <vector>

using namespace std;

class Solution {
public:
  int lastStoneWeight(vector<int> &stones) {
    priority_queue<int> pq;

    for (int stone : stones) {
      pq.push(stone);
    }

    while (pq.size() > 1) {
      int first = pq.top();
      pq.pop();
      int second = pq.top();
      pq.pop();

      if (first != second) {
        pq.push(first - second);
      }
    }

    return pq.empty() ? 0 : pq.top();
  }
};

int main() {
  Solution sol;

  vector<int> stones = {2, 7, 4, 1, 8, 1};
  cout << sol.lastStoneWeight(stones) << endl; // 1

  stones = {1};
  cout << sol.lastStoneWeight(stones) << endl; // 1
}
// @lc code=end
