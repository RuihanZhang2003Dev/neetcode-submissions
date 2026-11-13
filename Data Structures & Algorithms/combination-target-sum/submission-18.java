class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        /*
        idea: 2 choices, include current number stay, exclude current number advance.
        */
        dfs(nums, target, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] nums, int target, List<Integer> cur, int ind) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        else if (target < 0 || ind >= nums.length) return ;
        else {
            // include current number
            cur.add(nums[ind]);
            dfs(nums, target- nums[ind], cur, ind);
            cur.remove(cur.size() -1);
            dfs(nums, target, cur, ind+1);
        }
    }
}
