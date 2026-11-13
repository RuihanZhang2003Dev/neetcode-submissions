class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        /*
        idea: the min heap for start and end work, but running sum by iterating works here since there 
        will not be more than 1000 trips, very small number, practically O(n)
        */
        int[] sums = new int[1001];
        for (int[] trip: trips) {
            for (int i = trip[1]; i< trip[2]; i++) {
                sums[i] += trip[0];
                if (sums[i] > capacity) return false;
            }
        }
        return true;
    }
}