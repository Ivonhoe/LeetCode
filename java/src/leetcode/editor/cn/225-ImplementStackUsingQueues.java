package leetcode.editor.cn;

import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] Implement Stack using Queues
 *
 * https://leetcode-cn.com/problems/implement-stack-using-queues/description/
 *
 * algorithms
 * Easy (67.62%)
 * Likes:    544
 * Dislikes: 0
 * Total Accepted:    205.8K
 * Total Submissions: 304.4K
 * Testcase Example:  '["MyStack","push","push","top","pop","empty"]\n[[],[1],[2],[],[],[]]'
 *
 * Implement a last-in-first-out (LIFO) stack using only two queues. The
 * implemented stack should support all the functions of a normal stack (push,
 * top, pop, and empty).
 * 
 * Implement the MyStack class:
 * 
 * 
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * 
 * 
 * Notes:
 * 
 * 
 * You must use only standard operations of a queue, which means that only push
 * to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may
 * simulate a queue using a list or deque (double-ended queue) as long as you
 * use only a queue's standard operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * 
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * 
 * 
 * 
 * Follow-up: Can you implement the stack using only one queue?
 * 
 */

// @lc code=start
class MyStack {
    LinkedList<Integer> queue1 = null;
    LinkedList<Integer> queue2 = null;

    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue1.addLast(x);
    }

    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.addLast(queue1.getFirst());
                queue1.remove(0);
            }
            int ans = queue1.getFirst();
            queue1.remove(0);

            while (queue2.size() > 0) {
                queue1.addLast(queue2.getFirst());
                queue2.remove(0);
            }

            return ans;
        }

        return -1;
    }

    public int top() {
        return queue1.getLast();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
