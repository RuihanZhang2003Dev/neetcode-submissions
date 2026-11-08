class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
        idea: build a frequency list using hash map and bucket sort to get the most frequnt elements.
        the bucket sort is after you build the frequency list, you use frequency as index to build an
        array, the value corresponding to the index will be the element that occured index times in
        the originial array.
        */

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.put(n, freq.getOrDefault(n, 0) + 1);
        
        // bucket sort, the index is all possible frequencies in the array
        List<Integer>[] list = new List[nums.length +1]; 
        for (int i = 0; i < list.length; i++) list[i] = new ArrayList<>();
        // build the array
        for (int n: freq.keySet()) {
            list[freq.get(n)].add(n);
        }

        int[] result = new int[k];
        int index =0;

        // get the k top occurrance numbers
        for (int i = nums.length; i >= 0; i--) {
            for (int n: list[i]) {
                result[index] = n;
                index++;
                if (index == k) return result;
            }
        }
        
        return new int[]{};
    }
}
