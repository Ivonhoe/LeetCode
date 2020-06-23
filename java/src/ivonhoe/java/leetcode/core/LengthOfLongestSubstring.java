package ivonhoe.java.leetcode.core;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/explore/featured/card/bytedance/242/string/1012/
 * 
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
 * 
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1: 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2: 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3: 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
 * 的长度，"pwke" 是一个子序列，不是子串。
 */

/**
 * 时间复杂度O(N3)
 */
class Solution {
    private static final char CHAR = '\0';

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int length = s.length();
        char[] tempContainer = new char[length];
        clearCharList(tempContainer);

        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                boolean foundInTempList = foundInList(tempContainer, s.charAt(j));
                if (foundInTempList) {
                    if (j - i > maxLength) {
                        maxLength = j - i;
                    }
                    clearCharList(tempContainer);
                    break;
                } else {
                    tempContainer[j - i] = s.charAt(j);
                    if (j == length - 1) {
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                        }
                    }
                }
            }
        }
        return maxLength;
    }

    void clearCharList(char[] charList) {
        if (charList == null || charList.length < 1) {
            return;
        }

        for (int i = 0; i < charList.length; i++) {
            charList[i] = CHAR;
        }
    }

    boolean foundInList(char[] charList, char a) {
        if (charList == null || charList.length < 1) {
            return false;
        }

        for (char c : charList) {
            if (c == CHAR) {
                return false;
            } else if (a == c) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        // System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(
                "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }

    /**
     * 双指针，时间复杂度我O(N)
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int result = 0, start = 0, end = 0;
        Set<Character> set = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                result = Math.max(result, end - start);
            } else {
                set.remove(s.charAt(start++));
            }
        }

        return result;
    }

    /**
     * 双指针，时间复杂度我O(N)
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}