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
    public List<List<Integer>> levelOrder(TreeNode root) {
        /*
        idea: use a queue, so that we can add nodes that are in the same level into the queue
        then remove them when we count the total number and inster them into the result
        */

        // edge case: there is no tree
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()){
            List<Integer> tmpAns = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i< size; i++){
                TreeNode n = q.remove();
                tmpAns.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            result.add(tmpAns);
        }
        return result;
    }


}
