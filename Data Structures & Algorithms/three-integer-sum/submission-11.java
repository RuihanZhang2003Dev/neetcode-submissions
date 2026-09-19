class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        find all 3-num combinations that will give the sum 0, all number can
        only be used once, so sort the array first so that we can
        use 2 pointers, one from left and one from right, left being the smallest
        num, right being the largest num, usually the smallest num matches with
        the largest num and will be close to 0
        */

        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i< nums.length; i++){
            if (nums[i] > 0) break;
            if (i> 0 && nums[i] == nums[i -1]) continue;
            int left = i + 1;
            int right = nums.length -1;
            while (left < right) {
                ArrayList<Integer> tmpList = new ArrayList<>();
                int target = 0- (nums[left] + nums[i]);
                if (target != nums[right]){
                    if (target > nums[right]) {
                        left++;
                        continue;
                    }
                    right--;
                    continue;
                }
                tmpList.add(nums[i]);
                tmpList.add(nums[left]);
                tmpList.add(nums[right]);
                if (!result.contains(tmpList)) result.add(tmpList);
                left++;
                right = nums.length -1; // the moment we find the right match, reset the right instead of updating
            }
        }
        return result;
    }
}
