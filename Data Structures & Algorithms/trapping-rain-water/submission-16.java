class Solution {
    public int trap(int[] height) {
        /*
        idea: use 2 pointers for current left and right, and 2 more for maxleft
        and maxright. those can be just the max on the moment, max among the numbers
        that they ahve gone through. 
        */
        int left = 0;
        int right = height.length -1;
        int maxLeft = height[0];
        int maxRight = height[height.length-1];
        int result = 0;

        while (left <= right) {
            // if the maxleft is smaller or equal to maxright, then just move left,
            // update maxleft if necessary, and add result if necessary
            if (maxLeft <= maxRight) {
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
