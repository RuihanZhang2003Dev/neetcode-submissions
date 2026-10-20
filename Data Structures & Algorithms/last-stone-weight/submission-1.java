

class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        idea: use max heap through reversed order priority queue, poll the first 2, then put it 
        back to the queue after reduction
        */
        if (stones.length == 1) return stones[0];
        if (stones.length == 2) return Math.abs(stones[0] - stones[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // build the heap
        for (int i = 0; i< stones.length; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 2) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();

            int remainWeight = stone1 - stone2; // stone1> stone2 by default since they were
            // extracted from max heap
            pq.add(remainWeight);
        }

        int lastStone1 = pq.poll();
        int lastStone2 = pq.poll();
        return lastStone1- lastStone2;
    }
}
