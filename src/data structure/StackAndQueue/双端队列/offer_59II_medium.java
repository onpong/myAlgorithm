class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    
    public int max_value() {
        if(queue.isEmpty())
            return -1;
        return deque.peekFirst();
    }
    
    public void push_back(int value) {
        queue.add(value);
        while(!deque.isEmpty() && value > deque.peekLast()){
            deque.pollLast();
        }
        deque.add(value);
    }
    
    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int temp = queue.poll();
        if(temp == deque.peekFirst()){
            deque.pollFirst();
        }
        return temp;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */