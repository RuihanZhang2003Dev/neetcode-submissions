class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        /*
        idea: 2 choices, choose current number or just add it to the subset
        */
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> curList, int curInd) {
        if (curInd == nums.length) {
            res.add(new ArrayList(curList));
            return;
        }
        // 2 choices, choose cur num or not
        curList.add(nums[curInd]);
        dfs(nums, curList, curInd+1);
        curList.remove(curList.size() -1);
        dfs(nums, curList, curInd+1);
        
    }
}
