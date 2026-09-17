class Solution {
    public int[] twoSum(int[] nums, int target) {
        // idea: use hashmap to store the <remainder, index> pair
        // and as we iterate through nums, if one of the num matches the remainder
        // output solution
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< nums.length; i++){
            if (map.containsKey(nums[i])) return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }        
        return new int[]{};
    }
}
