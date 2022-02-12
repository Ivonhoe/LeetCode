package leetcode.editor.cn;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1984 lang=java
 *
 * [1984] Minimum Difference Between Highest and Lowest of K Scores
 *
 * https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/
 *
 * algorithms
 * Easy (63.35%)
 * Likes:    78
 * Dislikes: 0
 * Total Accepted:    35.3K
 * Total Submissions: 55.8K
 * Testcase Example:  '[90]\n1'
 *
 * You are given a 0-indexed integer array nums, where nums[i] represents the
 * score of the i^th student. You are also given an integer k.
 * 
 * Pick the scores of any k students from the array so that the difference
 * between the highest and the lowest of the k scores is minimized.
 * 
 * Return the minimum possible difference.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [90], k = 1
 * Output: 0
 * Explanation: There is one way to pick score(s) of one student:
 * - [90]. The difference between the highest and lowest score is 90 - 90 = 0.
 * The minimum possible difference is 0.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [9,4,1,7], k = 2
 * Output: 2
 * Explanation: There are six ways to pick score(s) of two students:
 * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 4 =
 * 5.
 * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 1 =
 * 8.
 * - [9,4,1,7]. The difference between the highest and lowest score is 9 - 7 =
 * 2.
 * - [9,4,1,7]. The difference between the highest and lowest score is 4 - 1 =
 * 3.
 * - [9,4,1,7]. The difference between the highest and lowest score is 7 - 4 =
 * 3.
 * - [9,4,1,7]. The difference between the highest and lowest score is 7 - 1 =
 * 6.
 * The minimum possible difference is 2.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= nums.length <= 1000
 * 0 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = nums[k-1]-nums[0];
        for(int i=k;i<nums.length;i++){
            ans = Math.min(ans, nums[i]-nums[i-k+1]);
        }

        return ans;
    }
}
// @lc code=end

