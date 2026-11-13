class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        /*
        idea: start at each char, and iterate through the rest of the string, check if from start to 
        current char is a palindrome, if so, recursive call starting at the next char.
        */
        part(s, new ArrayList<>(), 0);
        return res;
    }

    private void part(String s, ArrayList<String> cur, int ind) {
        if (ind >= s.length()) {
            res.add(new ArrayList<>(cur));
            return ;
        }
        else {
            for (int j = ind; j< s.length(); j++) {
                String tmp = s.substring(ind, j+1);
                // if it is palindrome, recursive call starting after palindrome and move on in the
                // next iteration of current loop
                if (isPalin(tmp)) {
                    cur.add(tmp);
                    part(s, cur, j +1);
                    cur.remove(cur.size() -1);
                }
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
