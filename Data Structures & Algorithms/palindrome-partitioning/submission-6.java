class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        idea: go through the whole string, at each iteration, check if we have iterated through
        a palindrome, if so, update the temporary answer, and then at the end of the recursion
        add the temporary answer to the result
        */
        List<String> tmpAns = new ArrayList<>();
        dfs(s, 0, tmpAns);
        return result;
    }

    // recursive method that will iterate through the string
    private void dfs(String s, int index, List<String> tmpAns){
        if (index == s.length()) {
            result.add(new ArrayList<>(tmpAns));
            return;
        }
        
        for (int j = index; j< s.length(); j++) {
            // if from i to j does not form a palindrome, skip iteration
            if (!isPalindrome(s.substring(index, j+1))) {
                continue;
            }
            tmpAns.add(s.substring(index, j+1));
            dfs(s, j+1, tmpAns);
            tmpAns.remove(tmpAns.size() -1);
        }

    }

    
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while (left< right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
