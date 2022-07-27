package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 *
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/description/
 *
 * algorithms
 * Easy (71.29%)
 * Likes:    283
 * Dislikes: 0
 * Total Accepted:    116.7K
 * Total Submissions: 168K
 * Testcase Example:  '[0,1,0]'
 *
 * An array arr a mountain if the following properties hold:
 * 
 * 
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * 
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * 
 * 
 * 
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] <
 * ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * 
 * You must solve it in O(log(arr.length)) time complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr = [0,1,0]
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr = [0,2,1,0]
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: arr = [0,10,5,2]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 3 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^6
 * arr is guaranteed to be a mountain array.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int middle = (high + low) / 2;
            if (middle == 0) {
                low = middle + 1;
            } else if (middle == arr.length - 1) {
                high = middle - 1;
            } else if (arr[middle] > arr[middle - 1] && arr[middle] > arr[middle + 1]) {
                return middle;
            } else if (arr[middle] > arr[middle - 1]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -1;
    }
}
// @lc code=end
