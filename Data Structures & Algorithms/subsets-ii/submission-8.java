class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        idea: sort the array, then 2 choices: choose this value, and in order to not choose the
        current value infinite amount of time, advance 1 value to avoid dup. or skip this value
        that would mean to completely iterate through all elements that has the same value
        */
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    // private helper
    private void dfs(int[] nums, ArrayList<Integer> cur, int ind) {
        // add current cur to the answer
        if (!res.contains(cur)) res.add(new ArrayList<>(cur));
        if (ind >= nums.length) return ;
        else {
            // here lies 2 choices
            cur.add(nums[ind]);
            dfs(nums, cur, ind +1);
            cur.remove(cur.size() -1);
            ind++;
            while (ind < nums.length && nums[ind] == nums[ind -1]) ind++;
            dfs(nums, cur, ind);
        }
    }
}
