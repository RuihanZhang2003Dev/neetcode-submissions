class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // idea: use hashmap to store the groups of anagram, the key will be the
        // sorted version of that group. 
        
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i< strs.length; i++){
            char[] sortedString = strs[i].toCharArray();
            Arrays.sort(sortedString);
            String sorted = new String(sortedString);
            if (!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            map.get(sorted).add(strs[i]);
        }

        for (String key: map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}
