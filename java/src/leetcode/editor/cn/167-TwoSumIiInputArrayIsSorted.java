/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Medium (58.71%)
 * Likes:    692
 * Dislikes: 0
 * Total Accepted:    367.5K
 * Total Submissions: 626K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * Given a 1-indexed array of integers numbers that is already sorted in
 * non-decreasing order, find two numbers such that they add up to a specific
 * target number. Let these two numbers be numbers[index1] and numbers[index2]
 * where 1 <= index1 < index2 <= numbers.length.
 * 
 * Return the indices of the two numbers, index1 and index2, added by one as an
 * integer array [index1, index2] of length 2.
 * 
 * The tests are generated such that there is exactly one solution. You may not
 * use the same element twice.
 * 
 * Your solution must use only constant extra space.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We
 * return [1, 2].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: numbers = [2,3,4], target = 6
 * Output: [1,3]
 * Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We
 * return [1, 3].
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: numbers = [-1,0], target = -1
 * Output: [1,2]
 * Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We
 * return [1, 2].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= numbers.length <= 3 * 10^4
 * -1000 <= numbers[i] <= 1000
 * numbers is sorted in non-decreasing order.
 * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return binarySearch(numbers, target);
    }

    private int[] binarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[] { i + 1, mid + 1 };
                } else if (numbers[mid] < target - numbers[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return new int[] { -1, -1 };
    }

    private int[] twoPointer(int[] numbers, int target) {
        // 双指针法，从两头向中间逼近
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int temp = numbers[low] + numbers[high];
            if (temp == target) {
                return new int[] { low + 1, high + 1 };
            } else if (temp < target) {
                low++;
            } else {
                high--;
            }
        }

        return new int[] { -1, -1 };
    }
}
// @lc code=end
