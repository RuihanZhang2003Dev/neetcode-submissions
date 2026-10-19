class Solution {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        idea: start with 1 character, which will always be a palindrome, add it to the current
        list, and recurse to do the same with the rest of the string with that updated list, 
        then reset the list, and include the next character in the same string as the first 
        character, check if it forms a palindrome, if it does not, then skip this iteration, if 
        it does, same process of update list, recurse then reset list. do it until we partition 
        all the strings
        */
        ArrayList<String> sublist = new ArrayList<>();
        dfs(s, 0, sublist);
        return result;
        
    }

    // dfs to perform back trackng
    private void dfs(String s, int index, List<String> curPart) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curPart)); // save a copy so that when it resets, the
            // result is still saved
            return;
        }
        
        for (int j = index; j< s.length(); j++) {
            if (!isPalindrome(s.substring(index, j+1))) {
                continue;
            }
            curPart.add(s.substring(index, j+1)); // when there is a palindrome, update list
            dfs(s, j+1, curPart); // recurse with updated list
            curPart.remove(curPart.size()-1);   // reset the update for next iteration
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
