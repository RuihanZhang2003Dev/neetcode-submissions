class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        idea: use a hashset to avoid duplicates, so put all number in a set, then iterate through
        each number in the set, if the number is used, delete it, at a number, check if the set has
        curNum -1, if so, go until there is not, then go curNum +1

        we cannot delete element in hashset while we iterate through it, so we need to adapt: check
        if the current number has current num -1 in the set, if so, that means current num is in a
        sequence and will be counted later, and if it doesnt, that means the current num is the start
        of a sequence, then we the sequence from that number. and if the sequence is larger than the
        largest sequence in record, then replace it
        */
        
        Set<Integer> set = new HashSet<>();
        for (int n: nums) {
            set.add(n);
        }

        int maxSeq = 0;
        for (int n: set){
            if (set.contains(n -1)) continue;
            
            else {
                int curSeq = 1; // including it self
                int cur = n + 1;
                while (set.contains(cur)) {
                    cur++;
                    curSeq++;
                }
                maxSeq = Math.max(maxSeq, curSeq);
            }
            
        }
        return maxSeq;
    }
}
