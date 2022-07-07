package leetcode.editor.cn;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] Min Stack
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (57.79%)
 * Likes:    1346
 * Dislikes: 0
 * Total Accepted:    398.3K
 * Total Submissions: 683.1K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n' +
  '[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * 
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * 
 * 
 * You must implement a solution with O(1) time complexity for each
 * function.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * -2^31 <= val <= 2^31 - 1
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 * At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
 * 
 * 
 */

// @lc code=start
class MinStack {

    private Stack<Integer> stack = null;
    private Stack<Integer> temp = null;

    public MinStack() {
        stack = new Stack<Integer>();
        temp = new Stack<Integer>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            temp.push(val);
        } else {
            int value = temp.peek();
            if (val <= value) {
                temp.push(val);
            }
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int value = stack.pop();
        if (value == temp.peek()) {
            temp.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (temp.isEmpty()) {
            return -1;
        }
        return temp.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
// @lc code=end
