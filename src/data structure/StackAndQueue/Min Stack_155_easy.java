class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.empty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
    	//此处不能直接写min.peek() == stack.pop(),因为返回的是Integer类型，==比较的是地址，且不在-128~127范围内，没用到常量池技术，是不相等的。
    	//不过可以min.peek().euqals(stack.pop())
        int temp = stack.pop();
        if(temp == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */