class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        idea: iterate through the string, check if what we have iterated through is a palindrome
        if it is, include it in the tmpAns and iterate through the rest of the string, in the
        same manner, which means it will be recursive calls. and since we are recursing with
        backtrack, we are going to update tmp ans, make recursive call with that updated list,
        then reset that update so we can go to next step
        */
        List<String> tmpAns = new ArrayList<>();
        dfs(s, 0, tmpAns);
        return result;
    }

    // helper to perform dfs and recursive calls
    private void dfs(String s, int index, List<String> tmpAns){
        if (index == s.length()) {
            result.add(new ArrayList<>(tmpAns));
            return ;
        }
        
        for (int j = index; j< s.length(); j++) {
            // if the part is not palindrome, skip to the next iteration
            if (!isPalindrome(s.substring(index, j+1))){
                continue;
            }
            tmpAns.add(s.substring(index, j+1));
            dfs(s, j+1, tmpAns);
            tmpAns.remove(tmpAns.size() -1);
        }
    }

    // helper to check palindrome
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
