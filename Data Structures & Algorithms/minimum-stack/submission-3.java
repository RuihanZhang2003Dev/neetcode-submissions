class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        // idea: use min stack to trace the min in the stack at each push, so record the minimum at all 
        // moments
        // so that at each pop, you will always see the minimum value in the stack

        stack.push(val);
        if (min.isEmpty()) {
            min.push(val);
        }
        else{
            min.push(Math.min(val, min.peek()));
        }
        
        
    }
    
    public void pop() {
        stack.pop();
        min.pop();
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return min.peek();
    }
}
