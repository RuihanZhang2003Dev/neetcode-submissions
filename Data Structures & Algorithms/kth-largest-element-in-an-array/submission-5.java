class Solution {
    public int findKthLargest(int[] nums, int k) {
        /*
        idea: use a priority queue to store them, and get the top result by polling
        */
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i< nums.length; i++){
            q.add(nums[i]);
        }
        for (int i =0 ; i< k-1; i++){
            q.poll();
        }
        return q.poll();
    }
}
