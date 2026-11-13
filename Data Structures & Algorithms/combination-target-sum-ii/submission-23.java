class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // idea: 2 choices: take current or not take current, jump through all duplicates
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] cans, int target, List<Integer> cur, int ind) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        else if (target < 0 || ind >= cans.length) return ;
        else {
            // 2choices
            cur.add(cans[ind]);
            dfs(cans, target - cans[ind], cur, ind+1);
            // completely move on, skip all dups
            cur.remove(cur.size() -1);
            ind++;
            while (ind < cans.length && cans[ind] == cans[ind -1]) ind++;
            dfs(cans, target, cur, ind);
        }
    }
}
