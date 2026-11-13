class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // idea: to get permutation, we must go through all number in the first iteration, all number
        // except the chosen number for the future iterations, until all numbers are chosen for 1
        // permutation, since we have to start with every number and explore all future iteration
        // with every number as start
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, boolean[] picked, ArrayList<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        else {
            for (int i= 0; i< nums.length; i++) {
                if (!picked[i]) {
                    picked[i] = true;
                    cur.add(nums[i]);
                    dfs(nums, picked, cur);
                    cur.remove(cur.size() -1);
                    picked[i] = false;
                }
            }
        }
    }
}
