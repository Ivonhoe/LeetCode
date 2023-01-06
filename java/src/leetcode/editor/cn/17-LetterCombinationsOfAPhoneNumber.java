package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (57.68%)
 * Likes:    2249
 * Dislikes: 0
 * Total Accepted:    618.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = ""
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * 
 */

// @lc code=start
class Solution {

    private List<String> result = new ArrayList<>();

    private char[][] map = new char[][] { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
            { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return result;
        }
        List<Character> path = new ArrayList<>();
        bracktrack(path, digits, 0);
        return result;
    }

    private void bracktrack(List<Character> path, String digits, int p) {
        if (path.size() == digits.length()) {
            StringBuilder ans = new StringBuilder();
            for (Character c : path) {
                ans.append(c);
            }
            result.add(ans.toString());
            return;
        }

        int index = digits.charAt(p) - '0' - 1;
        for (int i = 0; i < map[index].length; i++) {
            path.add(map[index][i]);
            bracktrack(path, digits, p + 1);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end
