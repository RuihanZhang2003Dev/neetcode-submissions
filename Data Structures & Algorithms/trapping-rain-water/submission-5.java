class Solution {
    public int trap(int[] height) {
        /*
        solution: go through the array, get max left and max right by iterating,
        find 
        */

        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        // iterate through left
        for (int i = 1; i< height.length; i++){
            if (height[i-1] > maxLeft[i-1]) maxLeft[i] = height[i-1];
            else maxLeft[i] = maxLeft[i-1];
        }

        // iterate through right
        for (int i = maxRight.length -2; i >-1; i--) {
            if (height[i+1] > maxRight[i+1]) maxRight[i] = height[i+1];
            else maxRight[i] = maxRight[i+1];
        }


        int result = 0;
        for (int i = 0; i< height.length; i++){
            if (Math.min(maxLeft[i], maxRight[i]) - height[i] < 0) continue;
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return result;
        
    }
}
