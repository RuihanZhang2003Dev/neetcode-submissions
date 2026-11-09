class Solution {
    public boolean isValid(String s) {
        /*
        idea: use a stack to store the open brackets, when encountering the closing brackets, check if 
        the top of the stack matches it, if so, pop it.
        */
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i< s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(' || cur == '[' || cur == '{') {
                stack.push(cur);
            }
            else if (stack.isEmpty()) return false;
            else {
                if (cur == ')' && stack.peek() == '(' ||
                cur == '}' && stack.peek() == '{' ||
                cur == ']' && stack.peek() == '[' ) {
                    stack.pop();
                }
                else return false;
            }  
        }
        return stack.isEmpty();
    }
}
