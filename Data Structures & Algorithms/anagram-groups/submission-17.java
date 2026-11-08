class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use a hashmap, use the sorted string as keys and group all anagram
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s: strs){
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            String sorted = new String(sArray);

            if (!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            map.get(sorted).add(s);
        } 
        return new ArrayList<>(map.values());
    }
}
