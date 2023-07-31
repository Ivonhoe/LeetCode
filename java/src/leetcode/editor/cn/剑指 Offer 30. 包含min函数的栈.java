class MinStack {

    private Deque<Integer> stack1 = new LinkedList<>();
    // 永远取当前的最小值push
    private Deque<Integer> stack2 = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || stack2.peek()>=x){
            stack2.push(x);
        }else{
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */