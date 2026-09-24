class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        */
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> groups = new HashMap<>();
        
        for (int i = 0; i< strs.length; i++) {
            char[] sortedWord = strs[i].toCharArray();
            Arrays.sort(sortedWord);
            String sortedAnagram = new String(sortedWord);
            if (!groups.containsKey(sortedAnagram)) groups.put(sortedAnagram, new ArrayList<>());
            groups.get(sortedAnagram).add(strs[i]);
        }
        return new ArrayList<>(groups.values());
    }
}
