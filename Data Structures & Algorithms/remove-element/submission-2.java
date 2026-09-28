class Solution {
    public int removeElement(int[] nums, int val) {
        /*
        idea: find the element, mean while, use another pointer that points to the element of the
        final array, if the nums is not equal to val, then place that element to the position pointed by 
        the final array pointer
        */

        int count =0;
        int ind = 0;
        for (int i = 0; i< nums.length; i++){
            if (nums[i] != val) {
                nums[ind] = nums[i];
                ind++;
                count++;
            }
        }
        return count;
        
    }
}