import java.util.Stack;

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