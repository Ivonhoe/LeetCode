import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class CQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        if (stack1.isEmpty()) {
            return -1;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}

class CQueue2 {
    private Deque<Integer> stack1 = null;
    private Deque<Integer> stack2 = null;

    public CQueue2() {
        stack1 = new ArrayDeque<Integer>();
        stack2 = new ArrayDeque<Integer>();
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            return -1;
        }

        return stack1.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such: CQueue obj = new
 * CQueue(); obj.appendTail(value); int param_2 = obj.deleteHead();
 */