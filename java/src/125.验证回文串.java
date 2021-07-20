/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (47.23%)
 * Likes:    397
 * Dislikes: 0
 * Total Accepted:    252.2K
 * Total Submissions: 532.6K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 字符串 s 由 ASCII 字符组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        return solution2(s);
    }

    boolean solution2(String s){
        int left = 0,right = s.length()-1;
        while(left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left<right){
                if(Character.toLowerCase(s.charAt(right))==Character.toLowerCase(s.charAt(left))){
                    left++;
                    right--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    boolean solution1(String s){
        char[] temp = s.toCharArray();
        String ans = "";
        for(int i=0;i<temp.length;i++){
        if(Character.isLetterOrDigit(temp[i])){
            ans +=Character.toLowerCase(temp[i]);
        }
        }

        for(int i=0,j=ans.length()-1;i<j;i++,j--){
            if(ans.charAt(i)!=ans.charAt(j)){
                return false;
            }
        }
        return true
    }
}
// @lc code=end

