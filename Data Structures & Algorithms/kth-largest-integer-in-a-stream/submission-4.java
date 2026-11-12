class KthLargest {
    // use max heap, build the heap by adding all num in nums to the heap and pop k -1 element
    // at each add, add the value and pop the front
    PriorityQueue<Integer> minHeap;
    int kth;
    public KthLargest(int k, int[] nums) {
        minHeap =  new PriorityQueue<>();
        kth = k;
        for (int n: nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) minHeap.poll();
        }
        
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > kth) minHeap.poll();
        return minHeap.peek();
    }
}
