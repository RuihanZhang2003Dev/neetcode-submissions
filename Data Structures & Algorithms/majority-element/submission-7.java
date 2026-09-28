class Solution {
    public int majorityElement(int[] nums) {
        /*
        idea: to do it in linear time, use a counting int and a candidate int, if the count is 0, then 
        change candidatem, otherwise increase/decrease the count.
        */
        int can = nums[0];
        int count = 0;
        for (int num: nums) {
            if (count == 0) can = num;
            if (can == num) count++;
            else count--;

        }
        return can;
    }
}