package leetcode.editor.cn;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (59.72%)
 * Likes:    3616
 * Dislikes: 0
 * Total Accepted:    525.4K
 * Total Submissions: 854.4K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
 * section) are being trapped.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {

    public int trap(int[] height) {
        return solution1(height);
    }

    // 单调栈
    private int solution1(int[] height) {
        if (height == null) {
            return 0;
        }

        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int w = i - left - 1;
                int h = Math.min(height[left], height[i]) - height[top];

                ans += w * h;
            }
            stack.push(i);
        }

        return ans;

    }
}
// @lc code=end
