class Solution {
    public boolean checkValidString(String s) {
        /*
        idea: without the *, we can count the number of left and right parenthesis, if there is more 
        left, we can add right, if there is more right, we return false. Here * provides 3 
        possibilities: nothing, ( or ). Hence we will keep track of the left parenthesis, if there 
        is 0 left parenthesis at the end of iteration, then all left parenthesis are closed. if 
        at some point, there are more right parenthesis than left, then we cannot add left 
        parethesis at this point to fix it.
        so we will keep track of minLeft(always choosing right parenthesis with *) and maxLeft 
        (always choosing ( with *) as the number of left parenthesis available. if minLeft goes below 
        0, reset it to 0 since we cannot have more right parenthesis before adding more right 
        parenthesis. if maxLeft goes below 0, that means no matter what we do, we cannot generate 
        more left parenthesis
        */

        int minLeft = 0;
        int maxLeft = 0;
        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(i) == '(') {
                minLeft++;
                maxLeft++;
            }
            else if (s.charAt(i) == ')') {
                minLeft--;
                maxLeft--;
            }
            else {
                minLeft--;  // if * is )
                maxLeft++;  // if * is (
            }
            if (maxLeft < 0) return false;
            if (minLeft < 0) minLeft = 0;
        }
        return minLeft == 0;
    }
}
