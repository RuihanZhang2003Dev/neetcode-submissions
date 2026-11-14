class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // build a hashmap of order to access order easily when comparing
        // if all words are the same, the shorter one should go first.

        if (words.length < 2) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i< order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        
        // compare 2 strings at a time if the current string is not in the position, then it is not 
        // sorted
        for (int i = 0; i< words.length -1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];

            int len = Math.min(w1.length(), w2.length());
            boolean equal = true;
            for (int j =0; j< len; j++) {
                int pos1 = map.get(w1.charAt(j));
                int pos2 = map.get(w2.charAt(j));
                if (pos2 < pos1) return false;
                // pos1 < pos2 means not the same char, but in right order lexicographically, so break
                else if (pos1 < pos2) {
                    equal = false;
                    break;
                }
            }
            if (equal && w1.length() > w2.length()) return false;
        }
        return true;

    }
}