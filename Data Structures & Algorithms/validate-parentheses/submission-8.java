class Solution {
    public static boolean isValid(String s) {
        /*
        idea: use a stack to store the left ones and then pop when we 
        encounter right ones, they have to corespond in order to be valid
        */

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i< s.length(); i++){
            if (s.charAt(i) == '('|| s.charAt(i) == '{'|| s.charAt(i) == '['){
                stack.push(s.charAt(i));
                continue;
            }
            if ((s.charAt(i) == ')'|| s.charAt(i) == '}'|| s.charAt(i) == ']')
            && stack.isEmpty()) return false;

            if (s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) == '}' && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) == ']' && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            return false;
        }
            
        
       
                
        
        return stack.isEmpty();
    }
}
