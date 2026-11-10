class Solution {
    public int removeDuplicates(int[] nums) {
        /*
        idea: iterate through the array, start with the second element, if the element before current
        one is different, that means we can increase the number of unique element and advance left
        */
        int n = nums.length;
        int left = 0;

        for (int i = 1; i< n; i++) {
            if (nums[i] != nums[left]) {
                left++;
                nums[left] = nums[i];
            }
        }
        return left +1;
    }
}