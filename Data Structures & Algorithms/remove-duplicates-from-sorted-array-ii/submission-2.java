class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        idea: we skip the ones that already repeated twice, keep the ones that are not repeated
        twice. For that we use a separate index, advance the index if and only if the number 
        did not appear twice already.
        */
        int finalLen =0;
        for (int num : nums) {
            if (finalLen < 2 || num != nums[finalLen -2]){
                nums[finalLen] = num;
                finalLen++;
            }
        }
        return finalLen;

    }
}