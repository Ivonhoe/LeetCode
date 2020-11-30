//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 回溯算法 
// 👍 289 👎 0


#include "vector"
#include "string"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<string> findWords(vector<vector<char>> &board, vector<string> &words) {
        vector<string> res;
        //判断每个单词
        for (auto word : words) {
            if (exist(board, word)) {
                res.push_back(word);
            }
        }
        return res;
    }

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
