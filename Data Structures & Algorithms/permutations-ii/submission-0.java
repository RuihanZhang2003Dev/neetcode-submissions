class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // idea: sort the array, get the permutation with current start, then avoid all numbers
        // that are the same number of start to get to the next start
        Arrays.sort(nums);
        boolean[] picked = new boolean[nums.length];
        perm(nums, picked, new ArrayList<>());
        return res;
    }

    // helper
    private void perm(int[] nums, boolean[] picked, ArrayList<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        else {
            for (int i = 0; i< nums.length; i++) {
                // only for first iteration, find permutations of different starts
                if (!picked[i]) {
                    cur.add(nums[i]);
                    picked[i] = true;
                    perm(nums, picked, cur);
                    cur.remove(cur.size() -1);
                    picked[i] = false;
                    while (i + 1 < nums.length && nums[i] == nums[i +1]) i++;
                }
            }
        }
    }
}