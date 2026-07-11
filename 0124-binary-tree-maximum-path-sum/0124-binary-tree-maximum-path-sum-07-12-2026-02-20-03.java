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
    int INF = -100000000;
    int max = INF;
    public int maxPathSum(TreeNode root) {
        f(root);
        return max;
    }
    int f(TreeNode root){
        if(root == null) return INF;
        int left = f(root.left);
        int right = f(root.right);

        int max1 = Math.max(left, right);
        int max2 = Math.max(max1 + root.val, root.val);
        int max3 = Math.max(left + right + root.val, Math.max(max1, max2));
        max = Math.max(max, max3);

        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}