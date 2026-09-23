class Solution {
    public int search(int[] nums, int target) {
        /*
        idea: use 2 pointers, if they come across the same place but the number is not right, 
        then return -1
        */
        int l = 0;
        int r = nums.length-1;
        while(l <= r) {
            if (l == r && nums[l] != target) return -1;
            int mid = (l+r)/2;
            if (nums[mid] < target) l = mid+1;
            else if (nums[mid] > target) r = mid;
            else return mid;
        }
        
        return -1;
        
    }
    
}
