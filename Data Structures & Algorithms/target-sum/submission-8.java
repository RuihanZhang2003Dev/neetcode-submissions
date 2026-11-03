class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        /*
        idea: use bottom up from 0, the array for memoization will have to be the sum of the absolute 
        values of the elements. go from nums to nums and use current sum as index to store the number of 
        ways to arrive to the current sum,current sum is updated by + curNum and -curNum. we do not need 
        the whole grid, we will only need the row
        */

        int absSum = 0;
        for (int n: nums) {
            absSum += Math.abs(n);
        }
        if (Math.abs(target) > absSum) return 0;
        
        // +1 so that the sum will never go out of bound due to truncated divisions
        int[] row = new int[absSum * 2 + 1];    
        int zeroPos = row.length/2;
        row[zeroPos] = 1; // there is 1 way to form 0 from current sum

        for (int n: nums) {
            // at each iteration, create a new row base on the current row, then discard current row
            int[] newRow = new int[row.length];
            for (int i = 0; i< row.length; i++){
                if (row[i] != 0) {
                    int plus = i + n;   
                    // if n is negative, we started in the middle of array of length maxSum * 2 + 1, 
                    // meaining the updated index with current num (so the current sum) will not have
                    // index out of bound issue
                    int minus = i - n;
                    newRow[plus] += row[i];
                    newRow[minus] += row[i];
                }
                
            }
            row = newRow;
        }
        return row[zeroPos + target];
    }
}
