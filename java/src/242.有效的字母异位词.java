/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (63.97%)
 * Likes:    397
 * Dislikes: 0
 * Total Accepted:    248.5K
 * Total Submissions: 388.2K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        return solution1(s,t);
    }

    private boolean solution1(String s, String t){
       if (s.length() != t.length()) {
            return false;
        }
        char[] sCharList = s.toCharArray();
        char[] tCharList = t.toCharArray();

        Arrays.sort(sCharList);
        Arrays.sort(tCharList);
        return Arrays.equals(sCharList, tCharList);
    }

    private boolean solution2(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] temp = new int[26];
        for(int i=0;i<s.length();i++){
            temp[s.charAt(i)-'a']++;
            temp[t.charAt(i)-'a']--;
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]!=0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

