/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] Spiral Matrix
 *
 * https://leetcode.cn/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (49.37%)
 * Likes:    1438
 * Dislikes: 0
 * Total Accepted:    387K
 * Total Submissions: 783.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList();
        if (matrix == null || matrix.length <= 0) {
            return ans;
        }
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        boolean[][] flags = new boolean[m][n];

        // 方向向量
        int[][] degree = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int index = 0;
        while (i < m && j < n && i >= 0 && j >= 0 && !flags[i][j]) {
            flags[i][j] = true;
            ans.add(matrix[i][j]);
            int tempI = i + degree[index][0];
            int tempJ = j + degree[index][1];

            if (tempI >= m || tempI < 0 || (tempJ == j && flags[tempI][tempJ])) {
                index = (++index) % 4;
                i = i;
                j = j + degree[index][1];
            } else if (tempJ >= n || tempJ < 0 || (tempI == i && flags[tempI][tempJ])) {
                index = (++index) % 4;
                i = i + degree[index][0];
                j = j;
            } else {
                i = tempI;
                j = tempJ;
            }

        }

        return ans;
    }
}
// @lc code=end
