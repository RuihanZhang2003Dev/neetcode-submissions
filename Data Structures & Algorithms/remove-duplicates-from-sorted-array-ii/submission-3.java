class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        idea: use a separated index that indicate how large the final array will be
        updates only when conditions fits
        */
        int finalLen = 0;
        for (int num: nums){
            if (finalLen < 2 || num != nums[finalLen -2]){
                nums[finalLen++] = num;
            }
        }
        return finalLen;
    }
}