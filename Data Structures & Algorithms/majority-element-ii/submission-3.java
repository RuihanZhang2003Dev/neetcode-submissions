class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // idea: to get the linear time, use boyer-moore voting to find the 2 majority numbers: have
        // iterate through nums 2 times, first time, you iterate throught the array, you will find the
        // first 2 numbers that appeared, you keep count on those first 2 numbers, and decrease both
        // counts if the current num is none of them, if the count of one of them reaches 0 and we
        // encounter a new number, update the new majority nunber, at the end, the last 2 numbers are
        // the numbers who has potential to be majority. second iteration of array counts them and add
        // them in the result if needed
        int len = nums.length;
        int majorCount = len/3;
        List<Integer> result = new ArrayList<>();
        int n1 = Integer.MIN_VALUE; int n2= Integer.MIN_VALUE; int count1 = 0; int count2 = 0;
        for (int n: nums) {
            if (n1 == Integer.MIN_VALUE) n1 = n;
            else if (n2 == Integer.MIN_VALUE && n1 != n) n2 = n;
            else if (count1 == 0 && n1 != n && n2 != n) n1 = n;
            else if (count2 == 0 && n1 != n && n2 != n) n2 = n;
            
            if (n != n1 && n != n2) {
                count1--;
                count2--;
            }
            else if (n == n1) count1++;
            else if (n == n2) count2++;
        }

        count1 = 0; count2 = 0;
        for (int n: nums){
            if (n == n1) count1++;
            else if (n == n2) count2++;
        }
        if (count1 > majorCount) result.add(n1);
        if (count2 > majorCount) result.add(n2);
        return result;

    }
}