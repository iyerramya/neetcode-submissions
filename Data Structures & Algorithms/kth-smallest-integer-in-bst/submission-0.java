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
    public int kthSmallest(TreeNode root, int k) {
        int[] pos = new int[2];
        dfs(root, pos, k);
        return pos[1];
    }

    public void dfs(TreeNode root, int[] pos, int k) {
        if(root == null || pos[0] >= k) {
            return;
        } 
        dfs(root.left, pos, k);
        pos[0] += 1;
        if(pos[0] == k) {
            pos[1] = root.val;
            return;
        }
        dfs(root.right, pos,k);
    }
}
