/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 *
 * https://leetcode-cn.com/problems/number-of-islands/description/
 *
 * algorithms
 * Medium (49.57%)
 * Likes:    620
 * Dislikes: 0
 * Total Accepted:    119.9K
 * Total Submissions: 241.9K
 * Testcase Example:  '[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]'
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 
 * 此外，你可以假设该网格的四条边均被水包围。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 
 * 
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
    var dfs = function (grid, i, j) {
        if (grid.length == 0 || grid[0].length == 0) {
            return
        }

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return
        }
        if (grid[i][j] == '0') {
            return
        }
        grid[i][j] = '0'
        dfs(grid, i - 1, j)
        dfs(grid, i + 1, j)
        dfs(grid, i, j - 1)
        dfs(grid, i, j + 1)
    }

    if (grid.length == 0 || grid[0].length == 0) {
        return 0
    }

    var result = 0;
    var m = grid.length;
    var n = grid[0].length;
    for (var i = 0; i < m; i++) {
        for (var j = 0; j < n; j++) {
            if (grid[i][j] == '0') continue;
            if (grid[i][j] == '1') {
                result++
                dfs(grid, i, j)
            }
        }
    }

    return result;
};
// @lc code=end