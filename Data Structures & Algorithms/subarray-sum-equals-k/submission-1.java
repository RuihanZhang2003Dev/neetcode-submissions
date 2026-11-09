class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
        idea: use prefix sum, basically keep track of the number of ways to reach that prefix sum the
        prefix sum is the sum of all element from the beginning to the current one. the current prefix
        sum - k is a prefix sum in stored in the map, then add the number of ways to reach the prefix
        sum to the result. and alwasy increase the count of current prefix sum
        */

        Map<Integer, Integer> ways = new HashMap<>();
        int curSum = 0;
        int result = 0;
        ways.put(0, 1); // there is always a way to reach 0 initially, with no element included
        for (int n : nums) {
            curSum += n;
            if (ways.containsKey(curSum -k)) result += ways.get(curSum -k);
            if (!ways.containsKey(curSum)) ways.put(curSum, 0);
            ways.put(curSum, ways.get(curSum) +1);
        }
        return result;
    }
}