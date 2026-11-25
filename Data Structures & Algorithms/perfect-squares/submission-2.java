class Solution {
    public int numSquares(int n) {
        /*
        idea: bottom up dp, it is like coin change but with squares as nums
        */
        int[] ways = new int[n+1];
        List<Integer> valid_Nums = new ArrayList<>();
        Arrays.fill(ways, Integer.MAX_VALUE);
        for (int i = 1; i<= n ;i++) {
            if (i* i <= n) valid_Nums.add(i);
            else break;
        }
        
        // like combination 4, you try all valid entries and and find the minimum amount of number to
        // reach current number
        ways[0] = 0;
        for (int i = 0; i<= n; i++) {
            if (ways[i] == Integer.MAX_VALUE) continue;
            for (int num: valid_Nums){
                int sum = i + num*num;
                if (sum <= n) ways[sum] = Math.min(ways[sum], 1+ ways[i]);
            }
        }

        return ways[n];
    }
}