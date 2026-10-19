class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        /*
        idea: there are two choices: when you are not out of n, you can either choose to close 
        the parenthesis, or open another, and keep track of that difference. use back tracking
        */
        generate(0, 0, n, "");
        return result;
    }

    // helper build parenthesis, dfs as we go all the way down for one
    // solution before we have the chance for the other
    private void generate(int open, int closed, int target, String cur){
        if (open == target && closed == target) {
            result.add(cur);
            return ;
        }
        // if the string is empty, or if the last char is closed,
        // we can only add open parenthesis
        if ((cur.length() == 0 || open >= closed) && open < target) {
            generate(open +1, closed, target, cur + "(");
        }
        
        // backtracking means take all valid choices, so apply both when 
        // appropriate
        if (open > closed && closed < target) {
            generate(open, closed+1, target, cur+")");
        } 
    }
}
