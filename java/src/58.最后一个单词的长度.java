/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (34.62%)
 * Likes:    331
 * Dislikes: 0
 * Total Accepted:    201.4K
 * Total Submissions: 579.8K
 * Testcase Example:  '"Hello World"'
 *
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "Hello World"
 * 输出：5
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = " "
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅有英文字母和空格 ' ' 组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int start= 0;
        int end=-1;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(isChar(ch) && end<0){
                end=i;
                continue;
            }
            if(!isChar(ch)&&start<=0){
                start=i+1;
                break;
            }
        }

        return end-start+1;
    }

    private boolean isChar(char c){
        if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
            return true;
        }
        return false;
    }
}
// @lc code=end

