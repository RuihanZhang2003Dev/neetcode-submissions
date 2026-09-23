class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        idea: fix a num, set the 2 pointers, where left is cur +1 and right is the end,
        get the sum of these 3 numbers. if >0 then right too big, go left, if < 0, then
        go right since left too small, until l< r or you find sum == 0, use a hashSet
        to keep track of the set of index found
        */
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> unique = new HashSet<>();

        for (int i = 0; i< nums.length; i++){
            if (i> 0 && nums[i] == nums[i -1]) continue;
            int l = i+ 1;
            int r = nums.length-1;

            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) r--;
                else if (sum < 0) l++;
                else {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[l]);
                    cur.add(nums[r]);
                    if (!unique.contains(cur)) {
                        unique.add(cur);
                        result.add(cur);
                    }
                    l++;
                    r--;
                }
            }
        }
        return result;
        
    }
}
