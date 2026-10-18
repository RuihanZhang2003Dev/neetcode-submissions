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
        idea: use a queue to store all the info, we pop the current front of the queue
        put its children to the back of the queue and add that node to the current list
        */

        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();    // pop all the current elements in the queue()
                                        // those are the nodes that are in the same lvl
            ArrayList<Integer> tmpAns = new ArrayList<>();
            for (int i = 0; i< size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                tmpAns.add(cur.val);
            }
            result.add(tmpAns);
        }
        return result;

    }
}
