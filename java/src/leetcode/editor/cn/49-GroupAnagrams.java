package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode-cn.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (66.96%)
 * Likes:    1216
 * Dislikes: 0
 * Total Accepted:    364.2K
 * Total Submissions: 539K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * 
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 * Input: strs = ["a"]
 * Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        if (strs == null) {
            return null;
        }

        final Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            final int[] table = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                table[strs[i].charAt(j) - 'a']++;
            }

            final StringBuffer sb = new StringBuffer();
            for (int k = 0; k < table.length; k++) {
                if (table[k] != 0) {
                    sb.append((char) ('a' + k));
                    sb.append(table[k]);
                }
            }
            String key = sb.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(strs[i]);
            map.put(key, value);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end
