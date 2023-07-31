/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 *
 * https://leetcode-cn.com/problems/valid-parenthesis-string/description/
 *
 * algorithms
 * Medium (35.20%)
 * Likes:    375
 * Dislikes: 0
 * Total Accepted:    38.1K
 * Total Submissions: 100.2K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 
 * 
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: "()"
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "(*)"
 * 输出: True
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: "(*))"
 * 输出: True
 * 
 * 
 * 注意:
 * 
 * 
 * 字符串大小将在 [1，100] 范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new LinkedList<Integer>();
        Deque<Integer> starStack = new LinkedList<Integer>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                leftStack.push(i);
            } else if(c=='*'){
                starStack.push(i);
            }else{
                if(!leftStack.isEmpty()){
                    leftStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }
        }
        
        while(!leftStack.isEmpty()&&!starStack.isEmpty()){
            if(leftStack.pop()>starStack.pop()){
                return false;
            }
        }
        
        return leftStack.isEmpty();
    }
}
// @lc code=end

