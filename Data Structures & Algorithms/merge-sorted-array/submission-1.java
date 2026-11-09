class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        idea: go from back to front, compare biggest, we never have to worry about array 1 getting
        overridden since we are starting at m+n and after inserting n to the array, we are done with 
        insertion and can leave the rest since they are in order
        */
        int pointer1 = m -1;
        int pointer2 = n -1;
        int pointer3 = nums1.length -1;

        while (pointer1 >= 0 && pointer2 >= 0) {
            if (nums1[pointer1] > nums2[pointer2]) {
                nums1[pointer3] = nums1[pointer1];
                pointer3--;
                pointer1--;
            }
            else if (nums2[pointer2] >= nums1[pointer1]){
                nums1[pointer3] = nums2[pointer2];
                pointer3--;
                pointer2--;
            }
        }
        while (pointer2 >= 0) {
            nums1[pointer3] = nums2[pointer2];
            pointer3--;
            pointer2--;
        }
    }
}