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
    public int goodNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        List<Integer> goodNodes = new ArrayList<>();
        dfs(root, root.val, goodNodes);
        return goodNodes.size();
    }

    private void dfs(TreeNode root, int max, List<Integer> goodNodes) {
        if(root == null) {
            return;
        }
        if(root.val >= max) {
            max = root.val;
            goodNodes.add(root.val);
        }
        dfs(root.left, max, goodNodes);
        dfs(root.right, max, goodNodes);
    }
}
