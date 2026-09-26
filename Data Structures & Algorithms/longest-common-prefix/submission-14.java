class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLen = strs[0].length();
        int maxLen = strs[0].length();
        int minInd = 0;
        int maxInd = 0;
        for(int i=0; i<strs.length; i++){
            if(strs[i].length() < minLen){
                minLen = strs[i].length();
                minInd = i;
            } else{
                maxLen = strs[i].length(); // 9
                maxInd = i; // 0
            }
        }
        String s = strs[minInd];
        String t = strs[maxInd];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<minLen; i++){
            if(s.charAt(i) != t.charAt(i)){
                return sb.toString();
            }
            sb.append(s.charAt(i));
        }
        if(minLen == maxLen){
            return s;
        }
        return sb.toString();
    }
}