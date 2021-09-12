/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (44.48%)
 * Likes:    2640
 * Dislikes: 0
 * Total Accepted:    765.5K
 * Total Submissions: 1.7M
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "()"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "(]"
 * 输出：false
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：s = "([)]"
 * 输出：false
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：s = "{[]}"
 * 输出：true
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * s 仅由括号 '()[]{}' 组成
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if(s == null){
            return false;
        }

        Deque<Character> stack = new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else if(c==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c==']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(c=='}'){
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end

