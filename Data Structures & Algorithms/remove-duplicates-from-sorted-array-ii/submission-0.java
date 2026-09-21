class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        idea: use 2 pointers for the array, when we find 2 occurrences, reduce the final length
        until the next number, record the number, replace the numbers that reoccurred more than 
        2 times. repeat until the end. then return the length.
        */
        int write = 0;
        for (int num: nums){
            if (write < 2 || num != nums[write -2]){
                nums[write++] = num;
            }
        }
        return write;

    }
}