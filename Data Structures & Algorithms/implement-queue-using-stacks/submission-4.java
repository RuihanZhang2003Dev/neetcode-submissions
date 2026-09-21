class MyQueue {

    Stack<Integer> queue;
    int head;
    public MyQueue() {
        queue = new Stack<>();
    }
    
    public void push(int x) {
        if (queue.isEmpty()) {
            head = x;
        }
        queue.push(x);
    }
    
    public int pop() {
        Stack<Integer> tmpS = new Stack<>();
        while (!queue.isEmpty()){
            tmpS.push(queue.pop());
        }
        int result = tmpS.pop();
        if (!tmpS.isEmpty()) head = tmpS.peek();
        while (!tmpS.isEmpty()){
            queue.push(tmpS.pop());
        }
        return result;
    }
    
    public int peek() {
        return head;
    }
    
    public boolean empty() {
        return queue.isEmpty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */