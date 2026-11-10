class MyStack {
    // idea: use 1 queue to store all elements and another to store the top of the queue

    Queue<Integer> main;
    Queue<Integer> top;

    public MyStack() {
        main = new LinkedList<>();
        top = new LinkedList<>();
    }
    
    public void push(int x) {
        if (!top.isEmpty()) top.poll();
        main.offer(x);
        top.offer(x);
    }
    
    public int pop() {
        int popped = top.poll();
        // if there is only 1 element 
        if (main.size() == 1) {
            main.poll();
            return popped;
        }
        while (main.size() > 1) {
            top.offer(main.poll());
        }
        main.poll();
        while (top.size() > 1) {
            main.offer(top.poll());
        }
        main.offer(top.peek());
        return popped;
    }
    
    public int top() {
        return top.peek();
    }
    
    public boolean empty() {
        return main.isEmpty();
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