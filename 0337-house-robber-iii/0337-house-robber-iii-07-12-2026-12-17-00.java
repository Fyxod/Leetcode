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
    Map<TreeNode, int[]> map = new HashMap<>();
    public int rob(TreeNode root) {
        return f(root, 1);
    }
    int f(TreeNode root, int pick){
        if(root == null) return 0;
        int[] memo = map.computeIfAbsent(root, node -> new int[]{-1, -1});

        if(memo[pick] != -1) return memo[pick];

        if(pick == 1){
            return memo[pick] = Math.max(
                root.val + f(root.left, 0) + f(root.right, 0),
                f(root.left, 1) + f(root.right, 1)
            );
        }
        else return memo[pick] = f(root.left, 1) + f(root.right, 1);
    }
}