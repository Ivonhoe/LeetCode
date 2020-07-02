/*
 * @lc app=leetcode.cn id=240 lang=javascript
 *
 * [240] 搜索二维矩阵 II
 *
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/description/
 *
 * algorithms
 * Medium (40.87%)
 * Likes:    354
 * Dislikes: 0
 * Total Accepted:    64K
 * Total Submissions: 155.8K
 * Testcase Example:  '[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n' +
  '5'
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 
 * 
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 
 * 
 * 示例:
 * 
 * 现有矩阵 matrix 如下：
 * 
 * [
 * ⁠ [1,   4,  7, 11, 15],
 * ⁠ [2,   5,  8, 12, 19],
 * ⁠ [3,   6,  9, 16, 22],
 * ⁠ [10, 13, 14, 17, 24],
 * ⁠ [18, 21, 23, 26, 30]
 * ]
 * 
 * 
 * 给定 target = 5，返回 true。
 * 
 * 给定 target = 20，返回 false。
 * 
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
    return solution2(matrix, target)
};

// 左上角
function solution1 (matrix, target) {
    if (!matrix.length) {
        return false
    }

    var m = matrix.length
    var n = matrix[0].length
    for (var i = 0, j = 0; i < m && j < n;) {
        console.log(matrix[i][j])
        if (matrix[i][j] == target) {
            return true
        } else if (matrix[i][j] > target) {
            if (j - 1 >= 0) {
                j--
            } else {
                return false
            }
        } else {
            if (j + 1 <= n - 1) {
                if (matrix[i][j + 1] <= target) {
                    j++
                } else if (matrix[i][j + 1] > target) {
                    i++
                }
            } else {
                i++
            }

        }
    }

    return false
}

// 左下角
function solution2 (matrix, target) {
    var row = matrix.length;
    if (row === 0) return false;
    var col = matrix[0].length;

    var x = row - 1;
    var y = 0;

    while (x >= 0 && x < row && y >= 0 && y < col) {
        if (matrix[x][y] === target) return true;
        else if (matrix[x][y] < target) y++;
        else if (matrix[x][y] > target) x--;
    }
    return false
}
// @lc code=end

