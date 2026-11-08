class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        idea: fix one number and perform 2 sum with 2 pointers on the rest, sort the array before so 
        that the 2 pointers can operate properly, and by fixing 1 number and perform 2 sum on the 
        rest we avoid repetition
        */

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i< nums.length -2; i++) {
            int fixed = i;
            int left = i+1;
            int right = nums.length -1;

            while (left < right) {
                int sum = nums[fixed] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    List<Integer> tmpList = new ArrayList<>();
                    tmpList.add(nums[fixed]);
                    tmpList.add(nums[left]);
                    tmpList.add(nums[right]);
                    if (!result.contains(tmpList)) result.add(tmpList);
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
