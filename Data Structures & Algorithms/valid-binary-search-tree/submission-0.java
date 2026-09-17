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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, new int[]{Integer.MIN_VALUE});
    }
    
    private boolean dfs(TreeNode root, int[] maxValue) {
        if(root == null) {
            return true;
        }
        boolean leftVal = dfs(root.left, maxValue);
        boolean rootVal = root.val <= maxValue[0] ? false : true; 
        if(root.val > maxValue[0]) {
            maxValue[0] = root.val;
        }
        boolean rightVal = dfs(root.right, maxValue);
        return leftVal && rootVal && rightVal;
    }
}
