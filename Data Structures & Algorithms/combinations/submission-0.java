class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        // idea: 2 choices, choose current number or choose next number
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = i+1;
        dfs(nums, new ArrayList<>(), 0, k);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> cur, int ind, int k) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        else if (ind >= nums.length) return;
        else {
            // 2choices: choose cur or move on
            cur.add(nums[ind]);
            dfs(nums, cur, ind +1, k);
            cur.remove(cur.size() -1);
            dfs(nums, cur, ind+ 1, k);
        }
    }
}