class Solution {
    public int[] getConcatenation(int[] nums) {
        /*
        idea: use for loop, run through all the arrays and copy each elements
        */
        int[] result = new int[nums.length * 2];
        for (int i = 0; i< nums.length; i++){
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }
        return result;
    }
}