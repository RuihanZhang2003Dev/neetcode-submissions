class Solution {
    public int lengthOfLIS(int[] nums) {
        /*
        idea: dp is a good answer, but O(n2), can do better if we do dp + binary search
        */
        int len = nums.length;
        List<Integer> seq = new ArrayList<>();  // at each position we say: there is a sequence of 
        // length pos that ends with seq.get(pos)
        seq.add(nums[0]);
        int lIS = 1;
        for (int i =0; i< len; i++) {
            if (nums[i] > seq.get(seq.size() -1)) {
                seq.add(nums[i]);
                lIS++;
                continue;
            }
            // if it is not larger than the largest num in the list, find its position in the list
            // with binary search
            int ind = Collections.binarySearch(seq, nums[i]);
            if (ind < 0) ind = -ind -1; // if bs cannot find it, it returns the position where the
            // num should belong in negative
            seq.set(ind, nums[i]);
        }
        return lIS;
    }
}
