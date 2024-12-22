/*
 * @lc app=leetcode id=36 lang=cpp
 *
 * [36] Valid Sudoku
 */

// @lc code=start
#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  bool isValidSudoku(vector<vector<char>> &board) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    unordered_set<char> check;
    unordered_set<char> checkRow;
    unordered_set<char> checkColumn;

    // check rows and columns
    for (int i = 0; i < board.size(); i++) {
      checkRow.clear();
      checkColumn.clear();
      for (int j = 0; j < board[0].size(); j++) {
        char cR = board[i][j];
        if (checkRow.find(cR) == checkRow.end() || cR == '.') {
          checkRow.insert(cR);
        } else {
          return false;
        }
        char cC = board[j][i];
        if (checkColumn.find(cC) == checkColumn.end() || cC == '.') {
          checkColumn.insert(cC);
        } else {
          return false;
        }
      }
    }

    // check box
    for (int boxRow = 0; boxRow < 9; boxRow += 3) {
      for (int boxCol = 0; boxCol < 9; boxCol += 3) {
        check.clear();
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            char c = board[boxRow + i][boxCol + j];
            if (c != '.') {
              if (check.find(c) != check.end()) {
                return false;
              }
              check.insert(c);
            }
          }
        }
      }
    }

    return true;
  }
};

int main() {
  Solution sol;

  vector<vector<char>> board1 = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                 {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                 {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                 {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                 {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                 {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                 {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                 {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                 {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
  vector<vector<char>> board2 = {{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                                 {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                 {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                                 {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                                 {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                                 {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                                 {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                                 {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                 {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
  cout << boolalpha;
  cout << sol.isValidSudoku(board1) << "\n"; // true
  cout << sol.isValidSudoku(board2);         // false
}
// @lc code=end
