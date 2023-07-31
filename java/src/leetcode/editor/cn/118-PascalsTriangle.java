/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.cn/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (75.50%)
 * Likes:    1032
 * Dislikes: 0
 * Total Accepted:    428.5K
 * Total Submissions: 567.5K
 * Testcase Example:  '5'
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= numRows <= 30
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList();
        if (numRows <= 0) {
            return ans;
        }

        List<Integer> row1 = new ArrayList();
        row1.add(1);
        ans.add(row1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList();
            List<Integer> preRow = ans.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                int value1 = 0;
                if (j - 1 >= 0 && j - 1 < preRow.size()) {
                    value1 = preRow.get(j - 1);
                }

                int value2 = 0;
                if (j >= 0 && j < preRow.size()) {
                    value2 = preRow.get(j);
                }
                row.add(value1 + value2);
            }
            ans.add(row);
        }

        return ans;
    }
}
// @lc code=end
