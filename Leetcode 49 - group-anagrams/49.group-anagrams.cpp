/*
 * @lc app=leetcode id=49 lang=cpp
 *
 * [49] Group Anagrams
 */

// @lc code=start
#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<string>> groupAnagrams(vector<string> &strs) {
    vector<vector<string>> res;
    unordered_map<string, vector<string>> check;

    for (string s : strs) {
      string sorted = s;
      sort(s.begin(), s.end());
      check[s].push_back(sorted);
    }

    for (const auto &pair : check) {
      res.push_back(pair.second);
    }

    return res;
  }
};

int main() {
  Solution sol;
  vector<string> strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
  auto res = sol.groupAnagrams(strs);
  for (auto &vec : res) {
    for (auto &s : vec) {
      cout << s << ", ";
    }
  }

  cout << endl;
  vector<string> strs2 = {""};
  auto res2 = sol.groupAnagrams(strs2);
  for (auto &vec : res2) {
    for (auto &s : vec) {
      cout << s << " ";
    }
    cout << endl;
  }
}
// @lc code=end
