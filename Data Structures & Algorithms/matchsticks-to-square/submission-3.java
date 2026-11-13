class Solution {
    public boolean makesquare(int[] matchsticks) {
        /*
        idea: find the sum of matchsticks and divide by 4, if it is divisable, then we can start
        it will be finding target sums to reach the sum of matchstick /4, sort the matchsticks, 
        then iterate dfs through it
        */
        int sum = 0;
        for (int n: matchsticks) sum += n;
        
        if (sum %4 != 0) return false;
        int target = sum/4;
        Arrays.sort(matchsticks);
        int[] sides = new int[4];
        Arrays.fill(sides, target);
       
        return dfs(matchsticks, sides, matchsticks.length -1);
    }

    private boolean dfs(int[] ms, int[] sides, int ind) {
        // iterate through the match stick array, find if we can put the current match stick in one
        // of the sides, if we can, then we iterate through using that stick in that side, then we
        // skip sides who have the same value, since they will have the same outcome

        if (ind < 0) return true;
        HashSet<Integer> checked = new HashSet<>();
        for (int i = 0; i< sides.length; i++) {
            // if we can use the stick in current side, use it
            if (sides[i] >= ms[ind]) {
                sides[i] -= ms[ind];
                if (dfs(ms, sides, ind -1)) return true;
                sides[i] += ms[ind];
                checked.add(sides[i]);
            }
            while (i < sides.length && checked.contains(sides[i])) i++;
        }
        return false;
    }
    
}