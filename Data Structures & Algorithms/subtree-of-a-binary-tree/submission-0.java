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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
       if(subRoot == null) {
        return true;
       } 
       if(root == null) {
        return false;
       }
       if(checkIfMatch(root, subRoot)) {
            return true;
        }
        return  dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    private boolean checkIfMatch(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root !=null && subRoot != null && root.val == subRoot.val) {
            return checkIfMatch(root.left, subRoot.left) && checkIfMatch(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
