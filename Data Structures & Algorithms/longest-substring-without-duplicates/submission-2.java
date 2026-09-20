class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        idea: use sliding window, expand it when it is a unique character
        shrink it when a duplicate shows up, shrink until the duplicate is gone
        keep track of the current max length, update accordingly. use a hashset
        to keep track of the unique characters
        */
        HashSet<Character> usedLetter = new HashSet<>();
        int maxLength = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()){
            if (!usedLetter.contains(s.charAt(r)) || usedLetter.isEmpty()) {
                usedLetter.add(s.charAt(r));
                if (maxLength < usedLetter.size()) maxLength = usedLetter.size();
                r++;
            }
            else{
                // if there is a duplicate, remove hashset until duplicate
                while (l< r) {
                    if (s.charAt(l) == s.charAt(r)) {
                        l++;
                        r++;
                        break;
                    }
                    usedLetter.remove(s.charAt(l));
                    l++;
                    
                }
            }
        }
        return maxLength;
    }
}
