package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] Combination Sum II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (61.27%)
 * Likes:    1199
 * Dislikes: 0
 * Total Accepted:    381.4K
 * Total Submissions: 633K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * Given a collection of candidate numbers (candidates) and a target number
 * (target), find all unique combinations in candidates where the candidate
 * numbers sum to target.
 * 
 * Each number in candidates may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output: 
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output: 
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        // 先排序
        Arrays.sort(candidates);
        backtrack(path, new boolean[candidates.length], candidates, 0, target);
        return result;
    }

    private List<List<Integer>> result = new ArrayList<>();
    private int sum = 0;

    private void backtrack(List<Integer> path, boolean[] used, int[] candidates, int begin, int target) {
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length && candidates[i] + sum <= target; i++) {
            // 树的同一层去重，这里重点理解。。。
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtrack(path, used, candidates, i + 1, target);
            path.remove(path.size() - 1);
            sum -= candidates[i];
            used[i] = false;
        }
    }
}
// @lc code=end
