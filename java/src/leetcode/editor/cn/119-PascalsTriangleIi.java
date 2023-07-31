/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] Pascal's Triangle II
 *
 * https://leetcode.cn/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (68.91%)
 * Likes:    502
 * Dislikes: 0
 * Total Accepted:    276.5K
 * Total Submissions: 401.2K
 * Testcase Example:  '3'
 *
 * Given an integer rowIndex, return the rowIndex^th (0-indexed) row of the
 * Pascal's triangle.
 * 
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 * 
 * 
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= rowIndex <= 33
 * 
 * 
 * 
 * Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
 * space?
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows = rowIndex + 1;
        if (numRows <= 0) {
            return null;
        }

        List<List<Integer>> ans = new ArrayList();
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

        return ans.get(rowIndex);
    }
}
// @lc code=end
