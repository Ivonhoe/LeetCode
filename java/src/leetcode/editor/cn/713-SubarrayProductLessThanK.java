/*
 * @lc app=leetcode.cn id=713 lang=java
 *
 * [713] Subarray Product Less Than K
 *
 * https://leetcode.cn/problems/subarray-product-less-than-k/description/
 *
 * algorithms
 * Medium (49.61%)
 * Likes:    717
 * Dislikes: 0
 * Total Accepted:    103.6K
 * Total Submissions: 208.6K
 * Testcase Example:  '[10,5,2,6]\n100'
 *
 * Given an array of integers nums and an integer k, return the number of
 * contiguous subarrays where the product of all the elements in the subarray
 * is strictly less than k.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [10,5,2,6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly
 * less than k.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,3], k = 0
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 3 * 10^4
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return solution2(nums, k);
    }

    // 滑动窗口经典
    private int solution2(int[] nums, int k) {
        int ans = 0, value = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            // j作为滑动接口右边界，找到以j为结尾的最大边界
            // 则窗口内以j为结尾的连续子数组个数都是满足条件的
            value = value * nums[j];
            while (value >= k && i <= j && i < nums.length) {
                value = value / nums[i++];
            }
            ans += j - i + 1;
        }

        return ans;
    }

    // 暴利遍历
    private int solution1(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value < k) {
                ans++;
            } else {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                value = value * nums[j];
                if (value < k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
