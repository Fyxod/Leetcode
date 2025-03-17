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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftS = maxSum(root.left);
        int rightS = maxSum(root.right);

    max = Arrays.stream(new int[]{
        max, root.val + leftS + rightS, root.val + leftS, root.val + rightS, root.val
        }).max().getAsInt();

        return Arrays.stream(new int[]{
        root.val + leftS, root.val + rightS, root.val
        }).max().getAsInt();
    }
}