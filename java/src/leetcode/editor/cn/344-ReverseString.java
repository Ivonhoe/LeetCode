package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=344 lang=java
 *
 * [344] Reverse String
 *
 * https://leetcode-cn.com/problems/reverse-string/description/
 *
 * algorithms
 * Easy (77.89%)
 * Likes:    530
 * Dislikes: 0
 * Total Accepted:    453.2K
 * Total Submissions: 581.8K
 * Testcase Example:  '["h","e","l","l","o"]'
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * You must do this by modifying the input array in-place with O(1) extra
 * memory.
 * 
 * 
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^5
 * s[i] is a printable ascii character.
 * 
 * 
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if(s == null){
            return;
        }
        for(int left = 0, right = s.length-1;left<right;left++,right--){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
// @lc code=end

