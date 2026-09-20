class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        idea: fix 1 number, use the 2 pointers left and right to find if there is a
        pair that gives the right ans. 
        use arraylist to manage it
        */

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int l = 0;
        int r = nums.length -1;

        for (int i = 0; i< nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            l = i +1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) r--;
                else if (sum < 0) l++;
                else {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[l]);
                    tmpList.add(nums[r]);
                    if (!result.contains(tmpList)) result.add(tmpList);
                    l++;
                    r--;
                }
            }
            r = nums.length -1;
        }
        return result;

    }
}
