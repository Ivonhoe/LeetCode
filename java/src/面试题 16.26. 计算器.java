import java.util.Stack;

/**
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。 表达式仅包含非负整数，+， - ，*，/
 * 四种运算符和空格  。 整数除法仅保留整数部分。
 */
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