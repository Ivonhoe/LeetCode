package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] Maximum Number of Balloons
 *
 * https://leetcode-cn.com/problems/maximum-number-of-balloons/description/
 *
 * algorithms
 * Easy (64.68%)
 * Likes:    106
 * Dislikes: 0
 * Total Accepted:    49.8K
 * Total Submissions: 72.5K
 * Testcase Example:  '"nlaebolko"'
 *
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 * 
 * You can use each character in text at most once. Return the maximum number
 * of instances that can be formed.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: text = "nlaebolko"
 * Output: 1
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text = "leetcode"
 * Output: 0
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] strings = new int[5];
        for(int i=0;i<text.length();i++){
            char c = text.charAt(i);
            if(c == 'b') strings[0]++;
            else if(c == 'a') strings[1]++;
            else if(c == 'l') strings[2]++;
            else if(c == 'o') strings[3]++;
            else if(c == 'n') strings[4]++;
        }
        strings[2] = strings[2]/2;
        strings[3] = strings[3]/2;
        int ans = text.length();
        for(int i=0;i<strings.length;i++){
            ans = Math.min(ans, strings[i]);
        }
        return ans;
    }
}
// @lc code=end

