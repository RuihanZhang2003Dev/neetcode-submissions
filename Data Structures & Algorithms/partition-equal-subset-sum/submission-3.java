class Solution {
    public boolean canPartition(int[] nums) {
        /*
        idea: if you cannot even divide the sum by 2, then you cannot partition into equal subset
        sum. well if it is divisible by 2, then making 1 partition will prove that the rest will
        be in the other partition, so the objective is to make 1 partition. use bottom up DP to 
        solve this question.
        */
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false; // not divisible
        int target = sum /2;
        Arrays.sort(nums);

        int len = nums.length;
        int[] remain= new int[len];

        for (int i = len -1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // take the remain off?
                if(remain[j] == nums[i]) return true;
                else if (remain[j] > nums[i]) remain[j] -= nums[i];
            }
            remain[i] = target - nums[i];
            if (remain[i] == 0) {
                return true;
            }
        }
        return false;
    }
}
