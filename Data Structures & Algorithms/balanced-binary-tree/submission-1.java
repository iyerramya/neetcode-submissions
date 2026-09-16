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
    public boolean isBalanced(TreeNode root) {
        boolean res[] = new boolean[1];
        res[0] = true;
        int unused = dfs(root, res);
        return res[0];
    }
    public int dfs(TreeNode root, boolean[] res) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = res[0] && Math.abs(left-right) < 2;
        return 1+Math.max(left,right);
    }
}
