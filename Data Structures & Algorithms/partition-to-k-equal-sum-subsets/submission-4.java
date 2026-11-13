class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        /*
        idea: this is the saem question as matchsticks to square, just with different number of sides
        so we will check if the sum of the nums is divisible by k first, if so then we will set up 
        sides of length of k, and we will sort the nums and iterate nums from back to front so we can
        use up the larger values first. if the current num cannot fit in any of the k sides, then 
        return false. check current num with all sides, if it fits, use the num in that side and 
        dfs recursive call with updated sides.
        */
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % k != 0) return false;

        int target = sum/k;
        int[] sides = new int[k];
        Arrays.fill(sides, target);

        Arrays.sort(nums);
        return dfs(nums, sides, nums.length -1);
    }

    // helper for dfs
    private boolean dfs(int[] nums, int[] sides, int ind) {
        if (ind < 0) return true;   // reached the end of array
        else {
            HashSet<Integer> checked = new HashSet<>();
            for (int i =0 ; i< sides.length; i++) {
                if (sides[i] < nums[ind] || checked.contains(sides[i])) continue;
                sides[i] -= nums[ind];
                if (dfs(nums, sides, ind-1)) return true;
                sides[i] += nums[ind];
                checked.add(sides[i]);
            }
            return false;
        }
        
    }

}



