class Solution {
    public int evalRPN(String[] tokens) {
        /*
        idea: since we can assume that it gives valid arithmetic expressions, we can use a stack to store
        the number and the result during the operations. 
        */
        Stack<Integer> nums = new Stack<>();
        for (String s: tokens) {
            String cur = s;
            if (cur.equals("+")) {
                int n1= nums.pop();
                int n2 = nums.pop();
                nums.push(n1+n2);
            }
            else if (cur.equals("-")) {
                int n1= nums.pop();
                int n2 = nums.pop();
                nums.push(n2 -n1);
            }
            else if (cur.equals("*")) {
                int n1= nums.pop();
                int n2 = nums.pop();
                nums.push(n2 * n1);
            }
            else if (cur.equals("/")) {
                int n1= nums.pop();
                int n2 = nums.pop();
                nums.push(n2/n1);
            }
            else {
                nums.push(Integer.parseInt(cur));
            }
        }
        return nums.peek();
    }
}
