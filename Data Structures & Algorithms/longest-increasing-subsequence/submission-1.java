class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        idea: use bottoms up DP, go from back to front, when the current number is smaller than the 
        previous number, find the max number of sequence from those and add 1, assign it to the
        array
        */
        int len = nums.length;
        int[] seqLen = new int[len];
        seqLen[len -1] = 1; // base case
        
        for (int i = len - 2; i >= 0; i--) {
            int maxSeq = 0; // capture the current max sequence
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    // if nums[i] is part of a sequence, record it, if not, then it is its own seq
                    maxSeq = Math.max(seqLen[j], maxSeq);
                }  
            }
            seqLen[i] = 1+ maxSeq;
        }
        int max = Integer.MIN_VALUE;
        // final scan
        for (int seqlength: seqLen) {
            max = Math.max(seqlength, max);
        }
        return max;

    }
}
