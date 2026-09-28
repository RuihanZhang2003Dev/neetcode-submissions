class Solution {
    public int majorityElement(int[] nums) {
        /*
        idea: sort the array, find n/2 since the majority element takes more than half of the array, so
        the element in the middle of the array will always be the majority if the element
        */
        Arrays.sort(nums);
        return nums[nums.length /2];
    }
}