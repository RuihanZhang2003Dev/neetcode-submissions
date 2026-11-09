class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int pointer1 = 0;
        int pointer2 = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        while (pointer1< len1 && pointer2 < len2){
            result += word1.charAt(pointer1);
            result += word2.charAt(pointer2);
            pointer1++;
            pointer2++;
        }
        while (pointer1 < len1) {
            result += word1.charAt(pointer1);
            pointer1++;
        }

        while (pointer2 < len2) {
            result+= word2.charAt(pointer2);
            pointer2++;
        }
        return result;
    }
}