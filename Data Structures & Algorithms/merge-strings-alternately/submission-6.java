class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int pointer = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        while (pointer< len1 && pointer < len2){
            result.append(word1.charAt(pointer));
            result.append(word2.charAt(pointer));
            pointer++;
        }
        if (pointer < len1) result.append(word1.substring(pointer, len1));
        

        if (pointer < len2) result.append(word2.substring(pointer, len2));

        return result.toString();
    }
}