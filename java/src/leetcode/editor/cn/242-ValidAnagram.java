package leetcode.editor.cn;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] Valid Anagram
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (64.98%)
 * Likes:    635
 * Dislikes: 0
 * Total Accepted:    466.7K
 * Total Submissions: 711.8K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length, t.length <= 5 * 10^4
 * s and t consist of lowercase English letters.
 * 
 * 
 * 
 * Follow up: What if the inputs contain Unicode characters? How would you
 * adapt your solution to such a case?
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        return solution2(s, t);
    }

    private boolean solution1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sCharList = s.toCharArray();
        char[] tCharList = t.toCharArray();

        Arrays.sort(sCharList);
        Arrays.sort(tCharList);
        return Arrays.equals(sCharList, tCharList);
    }

    private boolean solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
