/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] Set Matrix Zeroes
 *
 * https://leetcode.cn/problems/set-matrix-zeroes/description/
 *
 * algorithms
 * Medium (63.28%)
 * Likes:    904
 * Dislikes: 0
 * Total Accepted:    262.1K
 * Total Submissions: 413.8K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -2^31 <= matrix[i][j] <= 2^31 - 1
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * A straightforward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best
 * solution.
 * Could you devise a constant space solution?
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> temp = new ArrayList();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    temp.add(new int[] { i, j });
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            _setZero(matrix, temp.get(i)[0], temp.get(i)[1]);
        }
    }

    private void _setZero(int[][] matrix, int k, int m) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[k][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][m] = 0;
        }
    }
}
// @lc code=end
