//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 698 👎 0


#include "vector"
#include "string"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool exist(vector<vector<char>> &board, string word) {
        int m = board.size();
        int n = board[0].size();

        vector<vector<bool>> used(m, vector<bool>(n, false));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word[0] && find(i, j, board, used, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    bool find(int i, int j, vector<vector<char>> &board, vector<vector<bool>> &used, int index, string word) {
        int m = board.size();
        int n = board[0].size();
        if (index == word.size()) {
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        if (used[i][j] || board[i][j] != word[index]) {
            return false;
        }

        used[i][j] = true;
        bool result = find(i + 1, j, board, used, index + 1, word) || find(i, j + 1, board, used, index + 1, word) ||
                      find(i - 1, j, board, used, index + 1, word) || find(i, j - 1, board, used, index + 1, word);
        if (result) {
            return true;
        }

        used[i][j] = false;

        return false;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
