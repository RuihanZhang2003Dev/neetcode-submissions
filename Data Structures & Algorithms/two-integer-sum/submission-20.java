class Solution {
    public int[] twoSum(int[] nums, int target) {
        // idea: use hashmap to store index, remain pair
        Map<Integer, Integer> remains= new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int remain = target - nums[i];
            if (remains.containsKey(nums[i])) return new int[]{remains.get(nums[i]), i};
            remains.put(remain, i);
        }
        return new int[]{};
    }
}
