class Solution {
    public boolean isValid(String s) {
        /*
        idea: use a stack to store the open ones, and when encountered with the closed ones
        check top of the stack, if they match, pop, it they dont return false, at the end, check
        if the stack is empty.
        */

        Stack<Character> open = new Stack<>();

        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == '(' ||
            s.charAt(i) == '{' ||
            s.charAt(i) == '['){
                open.push(s.charAt(i));
            }
            else {
                if (open.isEmpty()) return false;
                if (s.charAt(i) == ')' && open.peek() == '(') open.pop();
                else if (s.charAt(i) == '}' && open.peek() == '{') open.pop();
                else if (s.charAt(i) == ']' && open.peek() == '[') open.pop();
                else return false;
            }
        }
        return open.isEmpty();
    }
}
