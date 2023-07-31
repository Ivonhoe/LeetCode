/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.cn/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (49.36%)
 * Likes:    1964
 * Dislikes: 0
 * Total Accepted:    663K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all
 * overlapping intervals, and return an array of the non-overlapping intervals
 * that cover all the intervals in the input.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10^4
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> {
            return v1[0] - v2[0];
        });

        List<int[]> ans = new ArrayList();
        int index = -1;
        for (int[] _interver : intervals) {
            if (index == -1 || _interver[0] > ans.get(index)[1]) {
                ans.add(_interver);
                index++;
            } else {
                int[] item = ans.get(index);
                // item[0] = intervals[index][0];
                item[1] = Math.max(item[1], _interver[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
// @lc code=end
