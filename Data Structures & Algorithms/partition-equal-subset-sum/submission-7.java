class Solution {
    public boolean canPartition(int[] nums) {
        /*
        idea: use bottom up dp, go from front to back, build the array that stores the possible
        outcomes of adding elements from the num, if one possible outcome is the target, then 
        return true
        */
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum %2 == 1) return false;
        int target = sum / 2;
        
        boolean[] outcomes = new boolean[target +1];

        for (int n: nums) {
            if (n == target) return true;
            if (n < target) {
                // go back ward since we are assigning true to variables that are 
                for (int i = outcomes.length -1; i >= 0 ; i--) {
                    // if there was a possible sum and adding the curren num to possible sum gives
                    // within range of target, it becomes a new possible sum
                    if (outcomes[i] && i + n <= target)  outcomes[i+n] = true;
                }
                outcomes[n] = true;
            }
        }

        return outcomes[target];
    }
}
