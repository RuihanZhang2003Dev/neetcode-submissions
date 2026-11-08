class Solution {
    public List<Integer> partitionLabels(String s) {
        /*
        idea: record the last occurrances of each letter with hashmap, then we iterate through the 
        string again, now with a right bound to signify the end of the substring, at each character, 
        if the current character also occurred later outside the right bound, then we update
        the end of the iteration to where that letter appeared last, since between the occurrances
        of the same char, there is no more viable substrings, we count them as 1 substring.
        */
        HashMap<Character, Integer> occur = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i< s.length(); i++) {
            if (!occur.containsKey(s.charAt(i))) {
                occur.put(s.charAt(i), i);
            }
            occur.put(s.charAt(i), i);
        }

        // now we iterate again
        int end = 0;
        int cur = 0;
        int size = 0;
        while (cur < s.length()){
            end = occur.get(s.charAt(cur));
            while (cur <= end) {
                if (occur.get(s.charAt(cur)) > end) end = occur.get(s.charAt(cur));
                cur++;
                size++;
            }
            result.add(size);
            size = 0;
        }
        return result;

    }
}
