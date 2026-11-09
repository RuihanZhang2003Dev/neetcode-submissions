class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        idea: use binary search for rows, then cols
        */
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bot = rows -1;

        int finalRow = -1;
        while (top <= bot) {
            int mid = (top + bot)/2;
            // if mid is smaller than target, pick bot
            if (matrix[mid][cols -1] < target) top = mid+1;
            else if (matrix[mid][cols -1] > target) {
                // if the current row can contain the target element
                if (matrix[mid][0] <= target) {
                    finalRow = mid;
                    break;
                }
                else bot = mid -1;
            }
            else return true;
        }
        if (finalRow == -1) finalRow = top;
        if (top == rows) return false;
        int left = 0;
        int right = cols -1;
        int finalCol = -1;
        while (left <= right) {
            int mid = (left + right) /2;
            if (matrix[finalRow][mid] > target) right = mid -1;
            else if (matrix[finalRow][mid] < target) left = mid+1;
            else return true;
        }
        return false;
    }
}
