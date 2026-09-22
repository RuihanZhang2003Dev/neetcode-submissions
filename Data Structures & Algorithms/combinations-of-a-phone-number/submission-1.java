class Solution {
    public List<String> letterCombinations(String digits) {
        /*
        idea: use a hashmap to store the number, string pair. Use backtracking to find
        all possible combination, store it in a list
        */
        List<String> result = new ArrayList<>();
        HashMap<Character, String> numMap = new HashMap<>();
        numMap.put('2', "abc");
        numMap.put('3', "def");
        numMap.put('4', "ghi");
        numMap.put('5', "jkl");
        numMap.put('6', "mno");
        numMap.put('7', "pqrs");
        numMap.put('8', "tuv");
        numMap.put('9', "wxyz");

        if (digits.length() == 0) return result;
        dfs(digits, 0, "", numMap, result);

        return result;
    }

    public static void dfs(String digits, int index, String tmpAns, HashMap<Character, String> map, List<String> result){
        if (tmpAns.length() == digits.length()) {
            result.add(tmpAns);
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (char c: letters.toCharArray()){
            dfs(digits, index+1, tmpAns + c, map, result);
        }
    }
}
