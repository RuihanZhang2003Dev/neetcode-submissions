class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        /*
        idea: key observation: if one of the element in the triplet is larger than the one in the 
        target at the same position, then it is impossible to use that triplet to form the target
        since whatever we do, if we merge that triplet, then we will get the element larger than
        the one in target.

        so we iterate through the triplets, check if all elements in the current triplet is smaller
        than or equal to the one in target, if so, then we check if it has one of the element of the
        target at the right position, if so, we can use it in the merging process to get that element
        in the final result to match the target
        */

        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;

        int target1 = target[0];
        int target2 = target[1];
        int target3 = target[2];

        for (int[] triplet: triplets) {
            int cur1 = triplet[0];
            int cur2 = triplet[1];
            int cur3 = triplet[2];

            if (cur1 > target1 || cur2 > target2 || cur3 > target3) continue;

            check1 = check1 || (cur1 == target1);
            check2 = check2 || (cur2 == target2);
            check3 = check3 || (cur3 == target3);
        }
        return (check1 && check2 && check3);
    }
}
