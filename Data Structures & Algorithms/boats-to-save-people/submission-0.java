class Solution {
    public int numRescueBoats(int[] people, int limit) {
        /*
        idea: use counting sort, count the frequency of the weight and then sort it after, then use
        2 pointers. 
        */

        int maxWeight = 0;
        for (int weight: people) maxWeight = Math.max(weight, maxWeight);
        int[] freq = new int[maxWeight +1];
        for (int p: people) freq[p]++;
        int index = 0;
        int[] sorted = new int[people.length];
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0) {
                freq[i]--;
                sorted[index] = i;
                index++;
            }
        }
        
        // after sorting, use 2 pointers
        int l = 0;
        int r = sorted.length -1;
        int count = 0;
        while (l <= r) {
            // cant the lightest with heaviest, hence put heaviest alone in boat
            if (sorted[l] + sorted[r] > limit) {
                r--;
                count++;
            }
            else {
                l++;
                r--;
                count++;
            }
        }
        return count;
    }
}