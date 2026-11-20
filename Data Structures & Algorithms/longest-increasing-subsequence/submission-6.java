class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        idea: similar than the word search, find the largest subsequence that i can join and increase
        that count and put it in ith position
        */
        int len = nums.length;
        int[] longest = new int[len];
        for (int i = len- 1; i>= 0; i--) {
            int maxSeq = 0;
            for (int j = i; j < len; j++) {
                if (nums[i] < nums[j]) {
                    maxSeq = Math.max(maxSeq, longest[j]);
                }
            }
            maxSeq += 1;    // include self in the sequence
            longest[i] = maxSeq;
        }
        int max = 0;
        for (int maxSeq : longest) max = Math.max(max, maxSeq);
        return max;
    }
}
