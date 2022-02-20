/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] Squares of a Sorted Array
 *
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/description/
 *
 * algorithms
 * Easy (69.61%)
 * Likes:    432
 * Dislikes: 0
 * Total Accepted:    253.5K
 * Total Submissions: 364.2K
 * Testcase Example:  '[-4,-1,0,3,10]'
 *
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 * 
 * 
 * 
 * Follow up: Squaring each element and sorting the new array is very trivial,
 * could you find an O(n) solution using a different approach?
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;
        int startIndex = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= 0) {
                startIndex = i;
                break;
            }
        }
        for (int i = startIndex - 1, j = startIndex; i >= 0 || j <= nums.length - 1;) {
            if (i >= 0 && j <= nums.length - 1) {
                if (nums[i] * nums[i] < nums[j] * nums[j]) {
                    ans[index++] = nums[i] * nums[i];
                    i--;
                } else {
                    ans[index++] = nums[j] * nums[j];
                    j++;
                }
            } else if (i >= 0) {
                ans[index++] = nums[i] * nums[i];
                i--;
            } else {
                ans[index++] = nums[j] * nums[j];
                j++;
            }

        }
        return ans;
    }
}
// @lc code=end
