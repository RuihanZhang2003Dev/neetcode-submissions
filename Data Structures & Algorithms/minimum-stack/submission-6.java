class MinStack {
    /*
    idea: use a minstack to keep track of the whole minimum of the stack everytime we push
    something. and every time we pop, then we also pop the minstack
    */
    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if (min.isEmpty()){
            min.push(val);
        }
        else min.push(Math.min(val, min.peek()));
        stack.push(val);
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
