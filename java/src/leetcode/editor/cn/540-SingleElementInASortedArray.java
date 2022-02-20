package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] Single Element in a Sorted Array
 *
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (58.47%)
 * Likes:    450
 * Dislikes: 0
 * Total Accepted:    81.4K
 * Total Submissions: 133.5K
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * 
 * Return the single element that appears only once.
 * 
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(final int[] nums) {
        return solution2(nums);
    }

    /**
     * 有序数组，二分
     * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/solution/gong-shui-san-xie-er-duan-xing-fen-xi-yu-17nv/
     * 
     * @param nums
     * @return
     */
    private int solution2(final int[] nums) {
        int low = 0, high = nums.length - 1;
        int n = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                    // 在右边
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return nums[low];
    }

    /**
     * 步长为2向前循环检查，时间复杂度O(N)
     * 
     * @param nums
     * @return
     */
    private int solution1(final int[] nums) {
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                i = i + 2;
                j = j + 2;
                continue;
            } else {
                return nums[i];
            }
        }
        return nums[i];
    }
}
// @lc code=end
