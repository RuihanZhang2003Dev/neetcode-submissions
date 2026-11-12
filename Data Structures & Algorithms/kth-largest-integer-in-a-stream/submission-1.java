class KthLargest {
    // use max heap, build the heap by adding all num in nums to the heap and pop k -1 element
    // at each add, add the value and pop the front
    PriorityQueue<Integer> maxHeap;
    int kth;
    public KthLargest(int k, int[] nums) {
        maxHeap =  new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        kth = k;
        for (int n: nums) maxHeap.offer(n);
    }
    
    public int add(int val) {
        maxHeap.offer(val);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i< kth -1; i++) {
            list.add(maxHeap.poll());
        }
        int res = maxHeap.peek();
        for (int n: list) maxHeap.offer(n);
        return res;
    }
}
