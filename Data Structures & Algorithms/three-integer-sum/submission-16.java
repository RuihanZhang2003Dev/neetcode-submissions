class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        idea: fix one number, do 2-sum on the rest, skip the same number when we iterating through
        for the fixed number. use 2 pointers, fix left first, check right, if right too small, then move
        left, otherwise if right too large, move right
        */

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i< nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1;
            int right = nums.length-1;
            for (int j = left; j< nums.length; j++){
                int target = 0 - (nums[i] + nums[j]);

                while (nums[right] > target && right > j) right--;
                if (j == right) break;
                if (nums[right] == target) {
                    ArrayList<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(nums[right]);
                    if (!result.contains(tmpList)) result.add(tmpList);
                } 
                right = nums.length-1;
                continue;
            }

        }
        
        return result;

    }
}
