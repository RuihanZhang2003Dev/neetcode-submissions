class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /*
        idea: use the fixed size sliding window to achieve the solution
        */
        int left = 0;
        int right = 0;
        Set<Integer> n = new HashSet<>();
        // grow the first window
        while (right < nums.length) {
            if (!n.isEmpty() && n.contains(nums[right])) return true;
            n.add(nums[right]);
            if (right - left == k) {
                n.remove(nums[left]);
                left++;
            }
            right++;
        }
        return false;
    }
}