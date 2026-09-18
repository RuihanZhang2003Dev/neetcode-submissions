class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            min.push(val);
        }
        else{
            Stack<Integer> tmp = new Stack<>();
            while (!min.isEmpty()){
                if (val > min.peek()) {
                    tmp.push(min.pop());
                }
                else {
                    min.push(val);
                    break;
                }
            }
            while (!tmp.isEmpty()) min.push(tmp.pop());
        }
        
        stack.push(val);
    }
    
    public void pop() {
        int popped = stack.pop();
        Stack<Integer> tmp = new Stack<>();
        while (!min.isEmpty()){
            if (popped == min.peek()) {
                min.pop();
                break;
            }
            tmp.push(min.pop());
        }
        while (!tmp.isEmpty()) min.push(tmp.pop());
    }
    
    public int top() {
        return stack.peek(); 
    }
    
    public int getMin() {
        return min.peek();
    }
}
