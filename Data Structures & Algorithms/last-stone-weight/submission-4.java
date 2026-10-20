

class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        idea: use max heap through reversed order priority queue, poll the first 2, then put it 
        back to the queue after reduction
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // build the heap
        for (int i = 0; i< stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            int remainWeight = stone1 - stone2; // stone1> stone2 by default since they were
            // extracted from max heap
            pq.add(remainWeight);
        }

        return pq.poll();
    }
}
