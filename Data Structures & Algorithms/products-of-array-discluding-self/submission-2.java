class Solution {
    public int[] productExceptSelf(int[] nums) {
        // idea: store the number excluded and the product without it in a hashmap
        // the key will be the number excluded, so that next time we encounter the same number,
        // we will know what is the product

        HashMap<Integer, Integer> pastProd = new HashMap<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!pastProd.containsKey(nums[i])){
                int tmpProd = 1;
                for (int j = 0; j< nums.length; j++){
                    if (j == i) continue;
                    tmpProd *= nums[j];
                }
                pastProd.put(nums[i], tmpProd);
            }
            result[i] = pastProd.get(nums[i]);
        }
        return result;
    }
}  
