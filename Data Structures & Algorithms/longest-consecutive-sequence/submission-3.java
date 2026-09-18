class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        idea: use a hashset to avoid duplicate, and then find the longest sequence
        by find if it is the beginning of the sequence (if this num -1 exists in the set)
        and then by finding if the following number exists in the set
        */

        HashSet<Integer> set = new HashSet<>();
        int longest = 0;
        for (int num: nums){
            set.add(num);
        }

        for (int num: set){
            if (!set.contains(num-1)){
                int current = num;
                int seq = 1;
                while (set.contains(current+1)){
                    current++;
                    seq++;
                }

                if (seq > longest) longest = seq;
            }
        }
        return longest;
    }
}
