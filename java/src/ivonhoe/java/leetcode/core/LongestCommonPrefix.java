package ivonhoe.java.leetcode.core;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1014/
 * 
 * 最长公共前缀
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"] 输出: "fl"
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }

        String result = "";
        String firstString = strs[0];
        for (int i = 0; i < firstString.length(); i++) {
            char charOfIndex = firstString.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];
                if (str == null || str.length() <= i) {
                    return result;
                }

                if (charOfIndex != str.charAt(i)) {
                    return result;
                }
            }
            result = result + charOfIndex;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestCommonPrefix(["flower","flow","flight"]);
    }
}