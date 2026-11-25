class Solution {
    public int numSquares(int n) {
        /*
        idea: bottom up dp, it is like coin change but with squares as nums
        */
        int[] leastNum = new int[n+1];
        List<Integer> valid_Nums = new ArrayList<>();
        Arrays.fill(leastNum, Integer.MAX_VALUE);
        for (int i = 1; i* i<= n ;i++) {
            valid_Nums.add(i);
        }
        
        // like combination 4, you try all valid entries and and find the minimum amount of number to
        // reach current number
        leastNum[0] = 0;
        for (int i = 0; i<= n; i++) {
            for (int num: valid_Nums){
                int sum = i + num*num;
                if (sum <= n) leastNum[sum] = Math.min(leastNum[sum], 1+ leastNum[i]);
            }
        }

        return leastNum[n];
    }
}