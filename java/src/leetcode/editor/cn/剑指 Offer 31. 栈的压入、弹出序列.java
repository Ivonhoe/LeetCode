import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。 假设压入栈的所有数字均不相等。例如，序列
 * {1,2,3,4,5}是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈
 * 序列的弹出序列。
 * 
 * 示例 1： 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1] 输出：true 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4, push(5), pop() -> 5, pop() ->
 * 3, pop() -> 2, pop() -> 1
 * 
 * 示例 2： 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2] 输出：false 解释：1 不能在 2 之前弹出。
 **/

public class Solution {
    /**
     * 辅助栈模拟进栈顺序，检查栈顶元素是不是等于当前出栈时的元素
     * 
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> temp = new Stack<Integer>();

        int i = 0;
        int pos = 0;
        while (i < pushed.length || pos < popped.length) {
            if (temp.isEmpty() && i < pushed.length) {
                temp.push(pushed[i]);
                i++;
                continue;
            }
            int pushTop = temp.peek();
            if (pos < popped.length && pushTop == popped[pos]) {
                pos++;
                temp.pop();
            } else if (i < pushed.length) {
                temp.push(pushed[i]);
                i++;
            } else {
                break;
            }
        }

        return temp.isEmpty();
    }

    public boolean solution2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<Integer>();
        int pos = 0;
        for (int i = 0; i < pushed.length;) {
            stack.push(pushed[i++]);
            while (!stack.isEmpty() && stack.peek() == popped[pos]) {
                stack.pop();
                pos++;
            }
        }

        return stack.isEmpty();
    }
}