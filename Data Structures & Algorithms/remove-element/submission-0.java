class Solution {
    public int removeElement(int[] nums, int val) {
        /*
        idea: find the element, remove it, then bubble it up
        */
        int count = 0;
        for (int i = 0 ; i< nums.length; i++){
            if (nums[i] == val) {
                count++;
                nums[i] = -1;
            }
        }

        int ind = 0;
        while (ind < nums.length -count) {
            while (nums[ind] == -1) {
                for (int i = ind; i < nums.length -1; i++){
                    nums[i] = nums[i+1];
                }
            }
            ind++;
        }
        return nums.length - count;
    }
}