class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        idea: start from each position, find all palindromes with that start and put it in result
        */
        part(s, new ArrayList<>(), 0);
        return res;
    }

    private void part(String s, ArrayList<String> cur, int ind) {
        if (ind == s.length()) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        
        for (int j = ind; j < s.length(); j++){
            String tmp= s.substring(ind, j +1);
            if (isPalin(tmp)) {
                // when encounter a palindrome, we have 2 choices, include it and go to next 
                // iteration, or not include it and stay
                cur.add(tmp);
                part(s, cur, j +1);
                cur.remove(cur.size() -1);
            }
        }
        
    }
    
    
    
    
    
    
    // palindrome check
    private boolean isPalin(String s) {
        int start = 0;
        int end = s.length() -1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    } 
}
