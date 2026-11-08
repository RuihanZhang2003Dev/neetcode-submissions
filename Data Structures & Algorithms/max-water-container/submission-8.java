class Solution {
    public int maxArea(int[] heights) {
        /*
        idea: keep track of the current max area, start by pointing left and right, we will be
        updating the bar with lower height since the higher bar has the potential to have
        a larger maxArea than the lower bar
        */

        int left = 0; 
        int right = heights.length -1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            maxArea = Math.max(area, maxArea);

            if (heights[left] > heights[right]) right--;
            else left++;
        }
        return maxArea;

    }
}
