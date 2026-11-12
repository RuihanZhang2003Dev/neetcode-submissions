/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        /*
        idea: the optimal approach is that we would store the options of rob current house or rob
        next house for all houses, if we rob current houses, we would calculate all sum of prof
        from the not robbing children nodes option, if we do not rob current houses, then we would
        calculate the sum of prof from the best option from children nodes(either rob or not)
        */

        int[] res = maxProf(root);
        return Math.max(res[0], res[1]);
    }

    private int[] maxProf(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] bestLeft = maxProf(root.left);
        int[] bestRight = maxProf(root.right);
         // 1 stores the best result for not robbing
        int rob = root.val + bestLeft[1] + bestRight[1];    
        // if skipped, that means we can rob all houses after current nodes
        int skip = Math.max(bestLeft[0], bestLeft[1]) + Math.max(bestRight[0], bestRight[1]);
        return new int[]{rob, skip};
    }

}




