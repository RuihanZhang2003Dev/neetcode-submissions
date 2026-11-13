class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // idea: stay in the same number or move on
        dfs(nums, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int target, ArrayList<Integer> cur, int ind) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        else if (target < 0 || ind >= nums.length) return;
        else {
            // 2 choices: stay or move on
            cur.add(nums[ind]);
            dfs(nums, target - nums[ind], cur, ind);
            cur.remove(cur.size() -1);
            dfs(nums, target, cur, ind+1);
        }
    }
}
