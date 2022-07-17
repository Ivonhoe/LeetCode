package leetcode.editor.cn;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] Daily Temperatures
 *
 * https://leetcode-cn.com/problems/daily-temperatures/description/
 *
 * algorithms
 * Medium (68.63%)
 * Likes:    1227
 * Dislikes: 0
 * Total Accepted:    325.1K
 * Total Submissions: 468.8K
 * Testcase Example:  '[73,74,75,71,69,72,76,73]'
 *
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the i^th day to get a warmer temperature. If there is no future
 * day for which this is possible, keep answer[i] == 0 instead.
 * 
 * 
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= temperatures.length <= 10^5
 * 30 <= temperatures[i] <= 100
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }

        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }

        return ans;
    }
}
// @lc code=end
