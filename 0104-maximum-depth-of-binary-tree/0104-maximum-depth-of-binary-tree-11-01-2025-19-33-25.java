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
    int max = 0;
    public int maxDepth(TreeNode root) {
        helper(root, 1);
        return max;
    }
    void helper(TreeNode root, int depth){
        if(root == null) return;
        max = Math.max(max, depth);
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }
}