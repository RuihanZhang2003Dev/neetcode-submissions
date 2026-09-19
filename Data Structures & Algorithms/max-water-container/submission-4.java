class Solution {
    public int maxArea(int[] heights) {
        /*
        idea: use 2 pointers to calculate the area, fix left and move right
        document the max height in the max Area, since they will always shrink,
        it is better to number if the min height on the current pair of heights
        is smaller than the max height
        */
 
        int maxArea = 0;
        int maxHeight = 0;
        for (int i = 0; i< heights.length; i++){
            if (heights[i] < maxHeight) continue;
            int r = heights.length-1;
            while (i< r) {
                if (maxHeight < Math.min(heights[i], heights[r])) {
                    maxArea = Math.max(maxArea, Math.min(heights[i], heights[r]) * (r-i));
                    maxHeight = Math.min(heights[i], heights[r]);
                }
                r--;
            }
        }
        return maxArea;
    }
}
