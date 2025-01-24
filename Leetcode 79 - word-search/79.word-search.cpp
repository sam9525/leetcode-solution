/*
 * @lc app=leetcode id=79 lang=cpp
 *
 * [79] Word Search
 */

// @lc code=start
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
private:
  bool dfs(vector<vector<char>> &board, string &word, int i, int j, int index) {
    if (index == word.length()) {
      return true;
    }

    if (i < 0 || i >= board.size() || j < 0 || j >= board[0].size() ||
        board[i][j] != word[index]) {
      return false;
    }

    char temp = board[i][j];
    board[i][j] = '#'; // mark as visited

    bool found = dfs(board, word, i - 1, j, index + 1) ||
                 dfs(board, word, i + 1, j, index + 1) ||
                 dfs(board, word, i, j - 1, index + 1) ||
                 dfs(board, word, i, j + 1, index + 1);

    // Restore the cell
    board[i][j] = temp;

    return found;
  }

public:
  bool exist(vector<vector<char>> &board, string word) {
    int m = board.size();
    int n = board[0].size();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dfs(board, word, i, j, 0))
          return true;
      }
    }

    return false;
  }
};

int main() {
  Solution sol;

  vector<vector<char>> board = {
      {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
  string word = "ABCCED";
  cout << sol.exist(board, word) << endl; // true

  board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
  word = "SEE";
  cout << sol.exist(board, word) << endl; // true

  board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
  word = "ABCB";
  cout << sol.exist(board, word) << endl; // false
};
// @lc code=end
