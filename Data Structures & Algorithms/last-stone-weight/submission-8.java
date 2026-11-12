class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        idea: use maxHeap, build it with stones weight and iterate until the heap size is 1
        */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for (int weight: stones) {
            maxHeap.offer(weight);
        }

        while (maxHeap.size() > 1) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();

            if (max1 != max2) maxHeap.offer(Math.abs(max1-max2));
        }
        if (maxHeap.isEmpty()) return 0;
        return maxHeap.poll();
    }
}
