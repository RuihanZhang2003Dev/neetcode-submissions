class Solution {
    public boolean makesquare(int[] matchsticks) {
        /*
        idea: we need to find if we separate matchsticks to form a square. so 4 equal sides. If 
        the sticks are not evend divisible by 4, no need to check, it cannot be separated into 4 
        parts. we will be using an array for 4 targets and reduce targets by using sticks, if we 
        cannot use the current stick to any of the sides, return false. if we can use it, update
        sides and recursive call
        */

        int sum = 0;
        for (int n: matchsticks) sum+= n;
        if (sum % 4 != 0) return false;

        int target = sum/4;
        int[] sides = new int[4];
        Arrays.fill(sides, target);
        Arrays.sort(matchsticks);

        return dfs(matchsticks, sides, matchsticks.length -1);
    }

    // helper for dfs
    private boolean dfs(int[] ms, int[] sides, int ind) {
        if (ind < 0) return true;
        else {
            HashSet<Integer> checked= new HashSet<>(); 
            for (int i = 0; i < sides.length; i++) {
                if (sides[i] < ms[ind]) continue;
                else {
                    sides[i] -= ms[ind];
                    if (dfs(ms, sides, ind -1)) return true;
                    sides[i] += ms[ind];
                    checked.add(sides[i]);
                }
                while (i < sides.length && checked.contains(sides[i])) i++;
            }
        }
        return false;
    }
}










