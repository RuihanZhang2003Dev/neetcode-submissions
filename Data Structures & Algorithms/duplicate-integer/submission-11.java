class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use hash set to avoid dup
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}