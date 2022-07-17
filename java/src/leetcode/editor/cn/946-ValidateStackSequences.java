package leetcode.editor.cn;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=946 lang=java
 *
 * [946] Validate Stack Sequences
 *
 * https://leetcode-cn.com/problems/validate-stack-sequences/description/
 *
 * algorithms
 * Medium (63.14%)
 * Likes:    248
 * Dislikes: 0
 * Total Accepted:    39.1K
 * Total Submissions: 61.1K
 * Testcase Example:  '[1,2,3,4,5]\n[4,5,3,2,1]'
 *
 * Given two integer arrays pushed and popped each with distinct values, return
 * true if this could have been the result of a sequence of push and pop
 * operations on an initially empty stack, or false otherwise.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4),
 * pop() -> 4,
 * push(5),
 * pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= pushed.length <= 1000
 * 0 <= pushed[i] <= 1000
 * All the elements of pushed are unique.
 * popped.length == pushed.length
 * popped is a permutation of pushed.
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        return solution1(pushed, popped);
    }

    public boolean solution1(int[] pushed, int[] popped) {
        Stack<Integer> temp = new Stack<Integer>();

        int pos = 0;
        for (int i = 0; i < pushed.length;) {
            if (temp.isEmpty()) {
                temp.push(pushed[i]);
                i++;
                continue;
            }
            int pushTop = temp.peek();
            if (pushTop == popped[pos]) {
                i++;
                pos++;
                temp.pop();
            } else {
                temp.push(pushed[i]);
                i++;
            }
        }

        return temp.isEmpty();
    }

    public boolean solution2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int pos = 0;
        for (int i = 0; i < pushed.length;) {
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && stack.peek() == popped[pos]) {
                stack.pop();
                pos++;
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end
