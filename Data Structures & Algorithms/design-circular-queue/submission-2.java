class MyCircularQueue {
    // idea: use arraylist to imitate the enqueue, and removefirst for pop
    List<Integer> queue;
    int maxSize;
    
    public MyCircularQueue(int k) {
        queue = new ArrayList<>();
        maxSize = k;
    }
    
    public boolean enQueue(int value) {
        if (!this.isFull()){
            queue.add(value);
            return true;
        }
        return false;
        
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) return false;
        queue.removeFirst();
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) return -1;
        return queue.get(0);
    }
    
    public int Rear() {
        if (this.isEmpty()) return -1;
        return queue.get(queue.size()-1);
    }
    
    public boolean isEmpty() {
        return queue.size() == 0;
    }
    
    public boolean isFull() {
        return queue.size() == maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */