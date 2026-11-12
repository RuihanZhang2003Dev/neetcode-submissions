class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        idea: quick select is faster in avg time but is slower in worst case, so the most intuitive 
        way is the min heap, as we build min heap, if we go over the size k, we will pop the minimum
        this way when we finish building min heap, we will have kth largest element in front
        */
        PriorityQueue<Integer> min= new PriorityQueue<>();
        for (int n: nums) {
            min.offer(n);
            if (min.size() > k) min.poll();
        }
        return min.peek();
    }
}
