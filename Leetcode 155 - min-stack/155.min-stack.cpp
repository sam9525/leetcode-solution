/*
 * @lc app=leetcode id=155 lang=cpp
 *
 * [155] Min Stack
 */

// @lc code=start
#include <iostream>
#include <stack>

using namespace std;

class MinStack {
private:
  stack<int> st;
  stack<int> minSt;

public:
  MinStack() {}

  void push(int val) {
    st.push(val);
    if (minSt.empty() || val <= minSt.top()) {
      minSt.push(val);
    }
  }

  void pop() {
    if (st.top() == minSt.top()) {
      minSt.pop();
    }
    st.pop();
  }

  int top() { return st.top(); }

  int getMin() { return minSt.top(); }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
// @lc code=end
