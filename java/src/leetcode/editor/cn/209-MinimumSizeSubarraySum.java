/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 *
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/
 *
 * algorithms
 * Medium (46.64%)
 * Likes:    1787
 * Dislikes: 0
 * Total Accepted:    576.7K
 * Total Submissions: 1.2M
 * Testcase Example:  '7\n[2,3,1,2,4,3]'
 *
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal
 * to target. If there is no such subarray, return 0 instead.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 * 
 * 
 * 
 * Follow up: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log(n)).
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        return solution2(target, nums);
    }

    // 暴力解法，双重循环，超时
    private int solution1(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(j - i + 1, ans);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // 滑动窗口
    private int solution2(int target, int[] nums) {
        int low = 0, high = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (high < nums.length) {
            sum += nums[high++];
            while (sum >= target) {
                ans = Math.min(high - low, ans);
                sum -= nums[low++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
// @lc code=end
