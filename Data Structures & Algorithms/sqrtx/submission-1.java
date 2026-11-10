class Solution {
    public int mySqrt(int x) {
        // idea: use the middle, if too large, go down by 1, if too small, go up by 1
        
        long left = 0;
        long right = x;
        long minDiff = x;
        long best = 0;

        while (left <= right) {
            long mid = left + (right -left)/2;
            long res = mid*mid;
            
            // if too large
            if (res > x) right = mid -1;
            else if (res < x) {
                long diff = Math.abs(res -x);
                if (minDiff > diff) {
                    minDiff = diff;
                    best = mid;
                }
                left = mid+1;
            }
            else return (int) mid;
        }
        return (int) best;
    }
}