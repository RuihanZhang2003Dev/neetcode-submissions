class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // idea: 2 choices: choose this num or choose next num first and this num later
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> cur, boolean[] picked) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        else {
            // start with each number
            for (int i = 0; i< nums.length; i++) {
                if (!picked[i]){
                    cur.add(nums[i]);
                    picked[i] = true;
                    dfs(nums, cur, picked);
                    cur.remove(cur.size() -1);
                    picked[i] = false;
                } 
            }
        }
    }
}
