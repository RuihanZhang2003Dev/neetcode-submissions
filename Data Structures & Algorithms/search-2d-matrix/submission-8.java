class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        idea: use binary search for rows and then binary search the search the column
        */
        // check for the first and last element of the middle row, if the target is in between that range
        // that is the row

        int finalRow = 0;
        int topRow =0;
        int botRow = matrix.length -1;
        int rowLen = matrix[0].length;

        while (topRow <= botRow) {
            int midRow = (topRow + botRow) /2;
            // check for if midRow is the row
            if (matrix[midRow][rowLen -1] < target){
                // if the end of the row is smaller than target, exclude that row and choose the bot part
                topRow = midRow+ 1;
            }
            else if (matrix[midRow][rowLen -1] > target){
                // if the start of the row is larger than target, include that row and choose the top part 
                if (matrix[midRow][0] > target) botRow = midRow -1;
                else if (matrix[midRow][0] < target) {
                    finalRow = midRow;
                    break;
                }
                else return true;
                
            }

            else return true;
        }

        // when we found the final row, perform binary search on that row
        int leftCol = 0;
        int rightCol = matrix[0].length-1;
        while (leftCol <= rightCol) {
            int midCol = (leftCol + rightCol) /2;
            // if the midcol too large, then take left
            if (matrix[finalRow][midCol] > target) rightCol = midCol -1;
            // if the midcol too small, take right
            else if (matrix[finalRow][midCol] < target) leftCol = midCol + 1;
            else return true;
        }
        return false;

    }
}
