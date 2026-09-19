class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        idea: fix one number, do 2-sum on the rest, skip the same number when we iterating through
        for the fixed number. use 2 pointers, fix left first, check right, if right too small, then move
        left, otherwise if right too large, move right
        */

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        for (int i = 0; i< nums.length; i++){
            if (nums[i] > 0) break;
            else if (i> 0 && nums[i] == nums[i-1]) continue;
            l = i + 1;
            r = nums.length -1;
            
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0){
                    l++;
                }
                else if (sum > 0) {
                    r--;
                }
                else {
                    ArrayList<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[l]);
                    tmpList.add(nums[r]);
                    if (!result.contains(tmpList)) result.add(tmpList);
                    l++;
                    r = nums.length -1;
                }
            }
        }
        
        
        return result;

    }
}
