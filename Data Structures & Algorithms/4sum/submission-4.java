class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        /*
        idea: the objective of this is to form a generic solution for x sum using recursion. Basically
        to get to x -1 sum, x-2 sum, until we reach 2 sum
        */
        // avoid duplicates
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i+ 1; j< nums.length; j++) {
                if (j > i+ 1 && nums[j] == nums[j -1]) continue;
                int left = j + 1;
                int right = nums.length -1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) left++;
                    else if (sum > target) right--;
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        left++; 
                        right--;
                        while (left < right && nums[left] == nums[left -1]) left++;
                    }
                }
                
            }
        }
        return result;
    }

}