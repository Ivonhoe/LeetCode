/*
 * @lc app=leetcode.cn id=485 lang=java
 *
 * [485] Max Consecutive Ones
 *
 * https://leetcode.cn/problems/max-consecutive-ones/description/
 *
 * algorithms
 * Easy (61.12%)
 * Likes:    401
 * Dislikes: 0
 * Total Accepted:    207.6K
 * Total Submissions: 339.5K
 * Testcase Example:  '[1,1,0,1,1,1]'
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive
 * 1s. The maximum number of consecutive 1s is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int count = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                int j = i;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                }
                count = Math.max(count, j - i);
                i = j;
            } else {
                i++;
            }
        }
        return count;
    }
}
// @lc code=end
