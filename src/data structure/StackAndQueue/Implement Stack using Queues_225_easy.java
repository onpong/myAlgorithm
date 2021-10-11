class MyStack {
    private List<Integer> queue1;
    private List<Integer> queue2;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new ArrayList<>();
        queue2 = new ArrayList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue2.add(x);
        while(!queue1.isEmpty()){
            queue2.add(queue1.get(0));
            queue1.remove(0);
        }
        List<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int temp = queue1.get(0);
        queue1.remove(0);
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        return queue1.get(0);
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */