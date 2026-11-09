class Solution {
    public int search(int[] nums, int target) {
        /*
        idea: find the middle num, if the middle num > target, choose left, if middle num < target,
        choose right, if middle num == target, return middle num
        */
        int left = 0;
        int right = nums.length -1;
        while (left <= right) {
            int mid = (left + right) /2;
            if (target < nums[mid]) right = mid -1;
            else if(target > nums[mid]) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
