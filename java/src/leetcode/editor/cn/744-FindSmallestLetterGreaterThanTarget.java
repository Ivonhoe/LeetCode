package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] Find Smallest Letter Greater Than Target
 *
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * algorithms
 * Easy (45.86%)
 * Likes:    236
 * Dislikes: 0
 * Total Accepted:    95.2K
 * Total Submissions: 195.5K
 * Testcase Example:  '["c","f","j"]\n"a"'
 *
 * Given a characters array letters that is sorted in non-decreasing order and
 * a character target, return the smallest character in the array that is
 * larger than target.
 * 
 * Note that the letters wrap around.
 * 
 * 
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is
 * 'a'.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "c"
 * Output: "f"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: letters = ["c","f","j"], target = "d"
 * Output: "f"
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 2 <= letters.length <= 10^4
 * letters[i] is a lowercase English letter.
 * letters is sorted in non-decreasing order.
 * letters contains at least two different characters.
 * target is a lowercase English letter.
 * 
 * 
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] <= target) {
                low = mid + 1;
            } else if (mid >= 1) {
                if (letters[mid - 1] > target) {
                    high = mid - 1;
                } else {
                    return letters[mid];
                }
            } else {
                return letters[mid];
            }
        }

        return letters[0];
    }
}
// @lc code=end
