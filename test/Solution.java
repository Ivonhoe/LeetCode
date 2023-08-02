package test;

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
                board[i][j] = ',';
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