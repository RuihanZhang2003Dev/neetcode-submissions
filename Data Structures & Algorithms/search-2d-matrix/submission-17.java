class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        idea: since the whole matrix is sorted, we can consider it as a giant array, and perform 
        binary search on it.
        */
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int len = rows * cols;
        int left = 0;
        int right = len -1;

        while (left <= right) {
            int mid = (left + right) /2;
            int midRow = mid/cols;
            int midCol = mid % cols;

            int midVal = matrix[midRow][midCol];
            if (midVal > target) right = mid -1;
            else if (midVal < target) left = mid+1;
            else return true;
        }
        return false;
    }
}
