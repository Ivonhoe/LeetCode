/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (45.80%)
 * Likes:    1066
 * Dislikes: 0
 * Total Accepted:    229.4K
 * Total Submissions: 500K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 * 。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCCED"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "SEE"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
 * "ABCB"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * m == board.length
 * n = board[i].length
 * 1 
 * 1 
 * board 和 word 仅由大小写英文字母组成
 * 
 * 
 * 
 * 
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 * 
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        
        boolean[][] visited = new boolean[m][n]; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board, visited, words, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, char[] words, int i, int j, int k){
        if(i<0||i>=board.length||j<0||j>=board[0].length||k>=words.length||
          visited[i][j] ){
            return false;
        }
        if(board[i][j]!=words[k]){
            return false;
        }else if(k == words.length-1){
            return true;
        }
        visited[i][j] = true;
        if(dfs(board, visited, words, i+1,j,k+1)||
          dfs(board, visited, words, i-1, j, k+1)||
          dfs(board, visited, words, i, j+1, k+1)||
          dfs(board, visited, words, i, j-1, k+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
// @lc code=end

