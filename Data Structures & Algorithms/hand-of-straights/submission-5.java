class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        /*
        idea: we can keep count of the frequencies of values and track the minimum, if hand's
        length is not divisable by group size, impossble. when min amount reaches 0, we 
        discard the minimum to move onto the next minimum
        */
        if (hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> mins = new PriorityQueue<>();
        Map<Integer, Integer> freq = new HashMap<>();
        // build frequency and minimum stacks
        for (int n : hand) {
            if (!freq.containsKey(n)) {
                freq.put(n, 0);
                mins.offer(n);
            }
            freq.put(n, freq.get(n) +1);
        }

        while (!mins.isEmpty()) {
            int curMin = mins.poll();
            if (freq.get(curMin) > 0) {
                int occurMin = freq.get(curMin);
                for (int i = 1; i< groupSize; i++) {
                    if (freq.getOrDefault(curMin + i, 0) == 0) return false;
                    freq.put(curMin + i, freq.get(curMin + i) -occurMin);
                    if (freq.get(curMin + i) < 0) return false;
                }
            }
            
        }
        return true;
    }
}
