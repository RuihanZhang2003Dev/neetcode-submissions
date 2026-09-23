class KthLargest {
    /*
    k is just the offset of the sorted array from right to left
    */
    int[] nums;
    int offset;
    public KthLargest(int k, int[] nums) {
        offset = k;
        this.nums = nums;
    }
    
    public int add(int val) {
        int[] newNums = new int[nums.length + 1];
        for (int i = 0; i< nums.length; i++){
            newNums[i] = nums[i];
        }
        newNums[nums.length] = val;
        nums = newNums;
        Arrays.sort(nums);
        return nums[nums.length - offset];
    }
}
