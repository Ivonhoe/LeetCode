/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] Contiguous Array
 *
 * https://leetcode.cn/problems/contiguous-array/description/
 *
 * algorithms
 * Medium (54.67%)
 * Likes:    669
 * Dislikes: 0
 * Total Accepted:    69.5K
 * Total Submissions: 127.1K
 * Testcase Example:  '[0,1]'
 *
 * Given a binary array nums, return the maximum length of a contiguous
 * subarray with an equal number of 0 and 1.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number
 * of 0 and 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
 * number of 0 and 1.
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

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // 是1就+1，如果是0就-1，所以如果连续子数组的和为0，则0和1的个数相等
            sum += (nums[i] == 1 ? 1 : -1);
            // 如果map中取到了相同的数值，说明在这两个index之间的连续子数组中0和1的个数是相等的
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
// @lc code=end
