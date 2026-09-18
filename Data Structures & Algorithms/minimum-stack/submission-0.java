class MinStack {

    ArrayList<Integer> stack;
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        
    }
    
    public void pop() {
        stack.remove(stack.size()-1);
    }
    
    public int top() {
        return stack.get(stack.size()-1); 
    }
    
    public int getMin() {
        int min = stack.get(0);
        for (int num: stack) {
            if (num < min) min = num;
        }
        return min;
    }
}
