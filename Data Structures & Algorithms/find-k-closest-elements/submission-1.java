class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // idea: if arr allowed, shrink from the whole array
        int len = arr.length;
        List<Integer> closest = new ArrayList<>();
        
        int left = 0;
        int right = len-1;
        while (right -left +1 > k) {
            int leftDiff= Math.abs(arr[left] -x);
            int rightDiff= Math.abs(arr[right] -x);

            //tie breaker, keep the closer one
            // even if left diff is right diff, we always keep the smaller one, so we reject the 
            // larger one
            if (leftDiff <= rightDiff) right--;
            else left++;   
        }
            
        for (int i = left; i <= right; i++) {
            closest.add(arr[i]);
        }
        return closest;


    }
}