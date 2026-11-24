class Solution {
    public int combinationSum4(int[] nums, int target) {
        /*
        idea: iterate through 
        */

        if (target == 0) return 1; 
        int[] ways = new int[target+1];
        ways[0] =1;
        for (int i = 0; i< ways.length; i++){
            for (int num: nums) {
                if (ways[i] != 0 && i + num <= target) {
                    ways[i+ num] += ways[i];
                }
            } 
        }
        return ways[target];
    }
}