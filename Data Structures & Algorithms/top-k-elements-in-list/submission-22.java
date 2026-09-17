class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // idea: sort the array nums, use a hashmap to store frequency
        // hashmap will have <num, frequency> pair
        // from contraints we can already assume that nums will be of positive 
        // length and k will be a non zero length 

        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int i = 0; i< nums.length; i++){
            if (!map.containsKey(nums[i])) map.put(nums[i], 0);
            map.put(nums[i], map.get(nums[i])+1);
        }  

        for (int i = 0; i< k; i++){
            int maxFreq = 0;
            for (int num: map.keySet()){
                if (map.get(num) > maxFreq) maxFreq = map.get(num);
            }

            for (int num: map.keySet()){
                if (map.get(num) == maxFreq){
                    result[i] = num;
                    break;
                }
            }

            Iterator<Integer> it = map.keySet().iterator();
            while (it.hasNext()){
                int key = it.next();
                if (map.get(key) == maxFreq){
                    it.remove();
                    break;
                }
            }
        }
        return result;  
    }
    
}
