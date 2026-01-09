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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int max = dfs(root);
        return dfs2(root, max, 1);
    }
    int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        return 1 + Math.max(left, right);
    }
    TreeNode dfs2(TreeNode root, int max, int level){
        if(root == null) return null;
        if(level == max) return root;

        TreeNode left = dfs2(root.left, max, level + 1);
        TreeNode right = dfs2(root.right, max, level + 1);

        if(left != null && right != null) return root;
        if(left != null) return left;
        return right;
    }
}