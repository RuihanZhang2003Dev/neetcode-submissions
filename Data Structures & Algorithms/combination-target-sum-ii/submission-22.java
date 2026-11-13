class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        /*
        idea: use a hashmap to store the element, and since we can only choose candidate once, we have
        2 choices: choose current, or choose next, but either way the current candidate will be 
        removed to avoid dups
        */
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] cans, int target, ArrayList<Integer> cur, int ind) {
        
        if (target == 0) {
            if (!res.contains(cur)) res.add(new ArrayList<>(cur));
            return;
        }
        else if (target < 0 || ind >= cans.length) return ;
        else {
            // here lies the 2 choice
            cur.add(cans[ind]);
            dfs(cans, target - cans[ind], cur, ind +1);

            cur.remove(cur.size()-1);
            // to avoid duplicates
            ind++;
            while (ind > 0 && ind < cans.length && cans[ind] == cans[ind -1]) ind++;
            dfs(cans, target, cur, ind);
        }
    }
}
