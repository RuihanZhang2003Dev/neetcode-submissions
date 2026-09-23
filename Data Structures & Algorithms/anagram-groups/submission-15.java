class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        idea: use a hashmap to store the sorted strings as key, at each iteration
        sort the current string, check if the sorted strings already exists in the hashmap
        ifso, add it to the arraylist, other wise add the sorted array as key, then add 
        the string in the bucket
        */
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> groupAnagram = new HashMap<>();

        for (int i = 0; i< strs.length; i++){
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            String sortedString = new String(sorted);
            // now check if sorted anagram key already exists
            if (!groupAnagram.containsKey(sortedString)) groupAnagram.put(sortedString, new ArrayList<String>());
            groupAnagram.get(sortedString).add(strs[i]);
        }
        for (String sortedAnagram: groupAnagram.keySet()){
            result.add(groupAnagram.get(sortedAnagram));
        }
        return result;
    }
}
