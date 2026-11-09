class Solution {
    public int[] sortArray(int[] nums) {
        // use quicksort
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int newEnd = partition(nums, start,end);
            quickSort(nums, start, newEnd -1);
            quickSort(nums, newEnd+1, end);
        }
        else return ;
    }


    // partition helper for quicksort
    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start; int j = end;
        // add bound i <= end to not go out of bound
        while (i <= end && i < j) {
            while (i <= end&& pivot >= nums[i]) i++;
            while (pivot < nums[j]) j--;
        
            // swap when we find a number at i that is larger than pivot and a number at j that is 
            // smaller than the pivot, swap them if i and j did not cross each other yet
            if (i < j) {
                int tmp= nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // after i and j crosses, swap pivot to position j, since j will be the last position where
        // the nums[j] < pivot.
        nums[start]= nums[j];
        nums[j] = pivot; 
        return j;
    }
}