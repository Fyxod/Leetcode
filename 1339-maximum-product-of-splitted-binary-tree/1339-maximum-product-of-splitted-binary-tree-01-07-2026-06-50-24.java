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
    public int maxProduct(TreeNode root) {
        Set<Long> set = new HashSet<>();
        long tot = dfsSum(root, set);
        long max = 0;
        for(long a : set){
            max = Math.max(max, (tot-a) * a);
        }
        return (int)(max % 1000000007);
    }
    long dfsSum(TreeNode root, Set<Long> set){
        if(root == null) return 0;
        long sum = root.val + dfsSum(root.left, set) + dfsSum(root.right, set);
        set.add(sum);
        return sum;
    }
}