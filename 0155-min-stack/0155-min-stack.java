class MinStack {

    Deque<Integer> dq;
    Deque<Integer> minDq;

    public MinStack() {
        dq = new ArrayDeque<>();
        minDq = new ArrayDeque<>();
    }
    
    public void push(int val) {
        dq.addLast(val);

        if(minDq.isEmpty() || val <= minDq.peekLast()) {
            minDq.addLast(val);
        }
    }
    
    public void pop() {
        if (dq.isEmpty()) return;
        int removedElement = dq.removeLast();

        if (removedElement == minDq.peekLast()) {
            minDq.removeLast();
        }
    }
    
    public int top() {
        return dq.peekLast();
    }
    
    public int getMin() {
        return minDq.peekLast();
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