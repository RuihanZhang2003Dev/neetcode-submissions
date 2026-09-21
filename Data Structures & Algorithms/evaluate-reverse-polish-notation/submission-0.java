class Solution {
    public int evalRPN(String[] tokens) {
        /*
        idea: use a stack to store the numbers, when encountered + - * or /, pop the top number
        and perform it with the bottom number, and push the result back to the stack
        */
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i< tokens.length; i++){
            if (nums.isEmpty()) nums.push(Integer.parseInt(tokens[i]));

            if (tokens[i].equals("+") ||
            tokens[i].equals("-") ||
            tokens[i].equals("*") ||
            tokens[i].equals("/")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                int result;
                if (tokens[i].equals("+")) result = num2 + num1;
                else if (tokens[i].equals("-")) result = num2 - num1;
                else if (tokens[i].equals("*")) result = num2 * num1;
                else result = num2/num1;
                nums.push(result);
            }
            else nums.push(Integer.parseInt(tokens[i]));
        }
        return nums.pop();
    }
}
