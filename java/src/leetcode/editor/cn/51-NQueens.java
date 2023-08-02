/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N-Queens
 *
 * https://leetcode.cn/problems/n-queens/description/
 *
 * algorithms
 * Hard (74.07%)
 * Likes:    1842
 * Dislikes: 0
 * Total Accepted:    321.3K
 * Total Submissions: 433.9K
 * Testcase Example:  '4'
 *
 * The n-queens puzzle is the problem of placing n queens on an n x n
 * chessboard such that no two queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * You may return the answer in any order.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space,
 * respectively.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as
 * shown above
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1
 * Output: [["Q"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 9
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        return solution1(n);
    }

    // 回溯算法，从第一个开始遍历+回溯
    private List<List<String>> solution1(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrace(n, 0, board);
        return ans;
    }

    /**
     * 
     * @param row   行
     * @param board 棋盘
     */
    private void backtrace(int n, int row, char[][] board) {
        if (row == n) {
            List<String> str = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                str.add(new String(board[i]));
            }

            ans.add(str);
            return;
        }

        for (int j = 0; j < n; j++) {
            // 判断当前行上的每个位置是否可以放皇后
            if (isOk(board, row, j)) {
                board[row][j] = 'Q';
                backtrace(n, row + 1, board);
                board[row][j] = '.';
            }
        }
    }

    private boolean isOk(char[][] board, int i, int j) {
        int row = i;
        int column = j;
        int n = board.length;
        // 正上方向是否有皇后
        while (row >= 0) {
            if (board[row--][j] == 'Q') {
                return false;
            }
        }

        row = i;
        column = j;
        // 左上方向是否哟皇后
        while (row >= 0 && column >= 0) {
            if (board[row--][column--] == 'Q') {
                return false;
            }
        }

        row = i;
        column = j;
        // 右上方向是否有皇后
        while (row >= 0 && column < n) {
            if (board[row--][column++] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
