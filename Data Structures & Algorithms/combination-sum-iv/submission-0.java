class Solution {
    public int combinationSum4(int[] nums, int target) {
        /*
        idea: iterate through nums and add the nums of ways to reach the target, sort the array first,
        so that we do not undercount
        */

        if (target == 0) return 1; 
        Arrays.sort(nums);
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