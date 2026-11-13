class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        /*
        idea: there is 2 choices: generate left or generate right parenthesis, I can generate left 
        as long as left count is not >n, i can generate right as long as right < left 
        */
        generate(n, new StringBuilder(), 0 ,0);
        return res;
    }

    // private helper to generate all results, dfs
    private void generate(int n, StringBuilder cur, int left, int right) {
        // base case: if left and right achieved n add it to result
        if (left == n && right == n) res.add(cur.toString());
        else {
            // try add left and right
            if (left < n) {
                cur.append('(');
                generate(n, cur, left+1, right);
                cur.deleteCharAt(cur.length() -1);
            }
            if (right < left) {
                cur.append(')');
                generate(n, cur, left, right+1);
                cur.deleteCharAt(cur.length() -1);
            }
        }
    }
}
