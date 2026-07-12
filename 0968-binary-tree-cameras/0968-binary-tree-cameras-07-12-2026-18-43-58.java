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
    int c = 0;
    public int minCameraCover(TreeNode root) {
        int res = f(root);
        if(res == 2) c++;
        return c;
    }
    int f(TreeNode root){
        if(root == null) return 1;
        int left = f(root.left);
        int right = f(root.right);

        if(left == 2 || right == 2) {
            c++;
            return 0;
        }
        if(left == 0 || right == 0) return 1;
        return 2;
    }
}