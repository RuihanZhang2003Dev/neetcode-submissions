class Solution {
    public void sortColors(int[] nums) {
        // 3 way partition: have low high and mid pointers, behind low stores all 0, behind high 
        // stores all 2, look at mid, if mid is 1, advance mid, if mid is 2, swap with high and 
        // advance high, if mid is 0, swap with low and advance low. Do no advance mid until we find
        // out that mid is now 1

        int low =0;
        int hi = nums.length -1;
        int mid = 0;
        
        while (mid <= hi) {
            if (nums[mid] == 1) mid++;

            // since we will only get 1 or 0 from behind mid (mid will throw all 2s to after mid by
            // switching with hi and not advancing until mid is no longer 2)
            else if (nums[mid] == 0) {
                int tmp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = tmp;
                low++;
                mid++;
            }
            else if (nums[mid] == 2) {
                int tmp = nums[mid];
                nums[mid] = nums[hi];
                nums[hi] = tmp;
                hi--;
            }
        }
    }
}