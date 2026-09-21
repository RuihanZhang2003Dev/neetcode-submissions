class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /*
        idea: use 2 pointers, if too big, right move left, if too small, left move right
        */
        int l = 0;
        int r = numbers.length -1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target) l++;
            else if (sum > target) r--;
            else return new int[]{l+1, r+1};
        }
        return new int[]{};
        
    }
}
