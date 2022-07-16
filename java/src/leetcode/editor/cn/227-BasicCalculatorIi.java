package leetcode.editor.cn;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode-cn.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (43.85%)
 * Likes:    590
 * Dislikes: 0
 * Total Accepted:    120.1K
 * Total Submissions: 272.3K
 * Testcase Example:  '"3+2*2"'
 *
 * Given a string s which represents an expression, evaluate this expression
 * and return its value. 
 * 
 * The integer division should truncate toward zero.
 * 
 * You may assume that the given expression is always valid. All intermediate
 * results will be in the range of [-2^31, 2^31 - 1].
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * Example 1:
 * Input: s = "3+2*2"
 * Output: 7
 * Example 2:
 * Input: s = " 3/2 "
 * Output: 1
 * Example 3:
 * Input: s = " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 3 * 10^5
 * s consists of integers and operators ('+', '-', '*', '/') separated by some
 * number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range
 * [0, 2^31 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Character> opt = new Stack<Character>();
        Stack<Integer> number = new Stack<Integer>();
        s = s.replace(" ", "");

        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int digit = 0;
                for (; index < s.length() && Character.isDigit(s.charAt(index)); index++) {
                    digit = 10 * digit + s.charAt(index) - '0';
                }
                number.push(digit);
            } else {
                while (!opt.isEmpty() && !priority(s.charAt(index), opt.peek())) {
                    calc(number, opt);
                }
                opt.push(s.charAt(index));
                index++;
            }
        }

        while (!opt.isEmpty()) {
            calc(number, opt);
        }

        return number.peek();
    }

    private void calc(Stack<Integer> number, Stack<Character> opt) {
        int number2 = number.pop();
        int number1 = number.pop();

        int result = 0;
        switch (opt.peek()) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
                break;
            default:
                ;
        }
        opt.pop();
        number.push(result);
    }

    private boolean priority(char a, char b) {
        if (a == '+' || a == '-') {
            return false;
        } else if (a == '*' || a == '/') {
            return (b == '+' || b == '-');
        } else {
            return false;
        }
    }
}
// @lc code=end
