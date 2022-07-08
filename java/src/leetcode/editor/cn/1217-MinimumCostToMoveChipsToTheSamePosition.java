package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=1217 lang=java
 *
 * [1217] Minimum Cost to Move Chips to The Same Position
 *
 * https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/description/
 *
 * algorithms
 * Easy (69.70%)
 * Likes:    168
 * Dislikes: 0
 * Total Accepted:    46.6K
 * Total Submissions: 62.9K
 * Testcase Example:  '[1,2,3]'
 *
 * We have n chips, where the position of the i^th chip is position[i].
 * 
 * We need to move all the chips to the same position. In one step, we can
 * change the position of the i^th chip from position[i] to:
 * 
 * 
 * position[i] + 2 or position[i] - 2 with cost = 0.
 * position[i] + 1 or position[i] - 1 with cost = 1.
 * 
 * 
 * Return the minimum cost needed to move all the chips to the same
 * position.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: position = [1,2,3]
 * Output: 1
 * Explanation: First step: Move the chip at position 3 to position 1 with cost
 * = 0.
 * Second step: Move the chip at position 2 to position 1 with cost = 1.
 * Total cost is 1.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: position = [2,2,2,3,3]
 * Output: 2
 * Explanation: We can move the two chips at position  3 to position 2. Each
 * move has cost = 1. The total cost = 2.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: position = [1,1000000000]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= position.length <= 100
 * 1 <= position[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minCostToMoveChips(int[] position) {
        return solution2(position);
    }

    private int solution2(int[] position) {
        int even = 0, odd = 0;
        for (int pos : position) {
            if ((pos & 1) != 0) {
                odd++;
            } else {
                even++;
            }
        }
        return Math.min(odd, even);
    }

    private int solution1(int[] position) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < position.length; i++) {
            int a = position[i];
            int result = 0;
            for (int j = 0; j < position.length; j++) {
                result += Math.abs(position[j] - a) % 2;
            }
            ans = Math.min(result, ans);
        }

        return ans;
    }
}
// @lc code=end
