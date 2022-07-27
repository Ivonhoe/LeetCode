package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] Find Peak Element
 *
 * https://leetcode-cn.com/problems/find-peak-element/description/
 *
 * algorithms
 * Medium (49.58%)
 * Likes:    855
 * Dislikes: 0
 * Total Accepted:    244.8K
 * Total Submissions: 494.4K
 * Testcase Example:  '[1,2,3,1]'
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, find a peak element, and return its
 * index. If the array contains multiple peaks, return the index to any of the
 * peaks.
 * 
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is
 * always considered to be strictly greater than a neighbor that is outside the
 * array.
 * 
 * You must write an algorithm that runs in O(log n) time.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index
 * number 2.
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak
 * element is 2, or index number 5 where the peak element is 6.
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 1000
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums[i] != nums[i + 1] for all valid i.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (middle == 0) {
                if (nums[middle] > nums[middle + 1]) {
                    return middle;
                }
                low = middle + 1;
            } else if (middle == nums.length - 1) {
                if (nums[middle] > nums[middle - 1]) {
                    return middle;
                }
                high = middle - 1;
            } else if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
                return middle;
            } else if (nums[middle] > nums[middle - 1]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
// @lc code=end
