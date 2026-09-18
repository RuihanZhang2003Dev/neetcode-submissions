class Solution {
    public int longestConsecutive(int[] nums) {
        // idea: sort the array, remove duplicate, then find the longest sequence
        // edge case: if nums is empty
        if (nums.length == 0) return 0;

        int maxSeq = 1;
        int tmpSeq = 1;
        Arrays.sort(nums);
        for (int i = 1; i< nums.length; i++){
            if(i == nums.length-1) {
                if (nums[i-1] == (nums[i]-1)) tmpSeq += 1; 
                if (tmpSeq > maxSeq) maxSeq = tmpSeq;
                break;
            }
            if (nums[i] == nums[i-1]) continue;
            if (nums[i-1] == (nums[i]-1)) tmpSeq += 1; 
            else {
                if (tmpSeq > maxSeq) maxSeq = tmpSeq;
                tmpSeq = 1;
            }
            System.out.println(tmpSeq);
        }
        return maxSeq;
    }


}
