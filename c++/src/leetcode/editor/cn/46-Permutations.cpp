//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 985 👎 0

#include<vector>
#include <unordered_set>

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<vector<int>> permute(vector<int> &nums) {
        vector<vector<int>> ans;
        if (nums.size() < 1) { return ans; }
        unordered_set<int> used;
        vector<int> path;
        dfs(nums, 0, used, path, ans);
        return ans;
    }

private:
    void dfs(vector<int> &nums, int depth, unordered_set<int> &used, vector<int> &path, vector<vector<int>> &ans) {
        if (depth == nums.size()) {
            ans.push_back(path);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (!used.count(nums[i])) {
                used.insert(nums[i]);
                path.push_back(nums[i]);
                dfs(nums, depth + 1, used, path, ans);
                path.pop_back();
                used.erase(nums[i]);
            }
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
