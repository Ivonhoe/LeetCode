//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 642 👎 0

#include "string"
#include "queue"
#include "unordered_set"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string> &wordList) {
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        // 如果endWord没有在wordSet出现，直接返回0
        if (wordSet.find(endWord) == wordSet.end()) return 0;
        // 初始化队列
        queue<pair<string, int>> que;
        que.push(pair<string, int>(beginWord, 1));
        while (!que.empty()) {
            pair<string, int> word = que.front();
            que.pop();
            if (word.first == endWord) {
                return word.second;
            }
            // 将当前string的每个字符挨个替换成a~z，看wordSet里面有没有，复杂度降为26*word.size()
            for (int i = 0; i < word.first.size(); i++) {
                string newWord = word.first; // 用一个新单词替换word，因为每次置换一个字母
                for (int j = 0; j < 26; j++) {
                    newWord[i] = j + 'a';
                    // 找到邻接的string，入队
                    if (wordSet.find(newWord) != wordSet.end()) {
                        que.push(pair<string, int>(newWord, word.second + 1));
                        wordSet.erase(newWord);
                    }
                }
            }
        }

        return 0;
    }
};
//leetcode submit region end(Prohibit modification and deletion)


int main() {
    return 0;
}