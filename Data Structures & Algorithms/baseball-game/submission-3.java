class Solution {
    public int calPoints(String[] operations) {
        // note: only pop on C, never delete
        Stack<Integer> scores = new Stack<>();
        int sum = 0;
        for (String s: operations) {
            

            // if +, assume there is always at least 2 nums, have to push back in order since it does 
            // not take out the 2 numbers we used to add
            if (s.equals("+")) {
                int num1 = scores.pop();
                int num2 = scores.peek();
                scores.push(num1);  // push it back
                scores.push(num1 + num2);
                sum += scores.peek();
            }
            // if D, double top score, can assume there is always 1 num
            else if (s.equals("D")) {
                scores.push(2* scores.peek());
                sum += scores.peek();
            }
            // if C, remove top score
            else if (s.equals("C")) {
                sum -= scores.peek(); 
                scores.pop();
            }
            else {
                scores.push(Integer.parseInt(s));
                sum += scores.peek();
            }
        }
        
        return sum;
    }

    /*
    private boolean isInt(String s) {
        // helper to check if s is a integer or not 
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }*/
}