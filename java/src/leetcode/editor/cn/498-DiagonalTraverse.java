/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] Diagonal Traverse
 *
 * https://leetcode.cn/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (55.86%)
 * Likes:    456
 * Dislikes: 0
 * Total Accepted:    110.7K
 * Total Submissions: 198.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix mat, return an array of all the elements of the array
 * in a diagonal order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int flag = 1, index = 0, i = 0, j = 0;
        while (index < ans.length && i >= 0 && j >= 0 && i < m && j < n) {
            ans[index++] = mat[i][j];
            i = i - flag;
            j = j + flag;
            if (j >= n) {
                i = i + flag + 1;
                j = j - flag;
                flag = flag * -1;
            }
            if (i >= m) {
                i = i + flag;
                j = j - flag + 1;
                flag = flag * -1;
            }
            if (i < 0) {
                i = 0;
                flag = flag * -1;
            }
            if (j < 0) {
                j = 0;
                flag = flag * -1;
            }
        }
        return ans;
    }
}
// @lc code=end
