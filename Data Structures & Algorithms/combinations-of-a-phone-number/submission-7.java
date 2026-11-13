class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        /*
        idea: put digit and its corresponding chars into a hashmap, then perform back tracking by 
        either choosing current letter for current digit or choose next letter for current digit
        */
        if (digits.length() == 0) return res;
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        combin(map, digits, new StringBuilder(), 0);
        return res;
    }

    private void combin(Map<Character, char[]> map, String digits, StringBuilder cur, int ind) {
        if (ind >= digits.length()) {
            res.add(cur.toString());
            return ;
        }
        else {
            char[] set =map.get(digits.charAt(ind));
            for (char c: set) {
                // try current char in combination, then remove it for next iteration
                cur.append(c);
                combin(map, digits, cur, ind+1);
                cur.deleteCharAt(cur.length() -1);
            }
        }
    }
}
