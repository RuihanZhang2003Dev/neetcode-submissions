class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        idea: 2 choices: either include the current character in the string we are building
        or not, if we include it, check if they are palindrome, if they are, create a new 
        list of string for them.
        */
        ArrayList<String> sublist = new ArrayList<>();
        dfs(s, 0, sublist);
        return result;
        
    }

    // dfs to perform back trackng
    private void dfs(String s, int index, List<String> curPart) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curPart));
            return;
        }
        
        for (int j = index; j< s.length(); j++) {
            if (!isPalindrome(s.substring(index, j+1))) {
                continue;
            }
            curPart.add(s.substring(index, j+1));
            dfs(s, j+1, curPart);
            curPart.remove(curPart.size()-1);
        }
            
    }


    // private isPalindrome
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    
}
