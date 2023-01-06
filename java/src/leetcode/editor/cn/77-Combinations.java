package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] Combinations
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (76.96%)
 * Likes:    1241
 * Dislikes: 0
 * Total Accepted:    467.6K
 * Total Submissions: 605.2K
 * Testcase Example:  '4\n2'
 *
 * Given two integers n and k, return all possible combinations of k numbers
 * chosen from the range [1, n].
 * 
 * You may return the answer in any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered
 * to be the same combination.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 20
 * 1 <= k <= n
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        backtrack(path, n, k, 1);
        return result;
    }

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    private void backtrack(List<Integer> path, int n, int k, int p) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        // 这里i<=n也可以，但是没有剪枝
        for (int i = p; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(path, n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
