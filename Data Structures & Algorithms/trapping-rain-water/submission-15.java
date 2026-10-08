class Solution {
    public int trap(int[] height) {
        /*
        solution: use left and right pointer, what matters is the bottle neck,
        so even if the pointer is not pointing toward  the max of the height, it
        still works since we are on the current left and right max.
        */

        int maxLeft = 0;
        int maxRight = height[height.length-1];
        int left = 0;
        int right = height.length-1;
        int result = 0;

        while (left <= right) {
            // if maxleft smaller than or equals to maxright, then move left, update 
            // maxleft if needed
            if (maxLeft <= maxRight){
                int tmpAmount = maxLeft - height[left];
                if (tmpAmount > 0) result += tmpAmount;
                if (height[left] > maxLeft) maxLeft = height[left];
                left++;
            }
            else {
                int tmpAmount = maxRight - height[right];
                if (tmpAmount > 0) result += tmpAmount;
                if (height[right] > maxRight) maxRight = height[right];
                right--;
            }
        }

        return result;
    }
}
