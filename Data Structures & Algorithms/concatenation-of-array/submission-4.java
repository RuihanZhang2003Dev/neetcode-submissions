class Solution {
    public int[] getConcatenation(int[] nums) {
        /*
        idea: use for loop, run through all the arrays and copy each elements
        */
        int n = nums.length;
        int[] result = new int[n * 2];
        for (int i = 0; i< n; i++){
            result[i] = nums[i];
            result[i + n] = nums[i];
        }
        return result;
    }
}