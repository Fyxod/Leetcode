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
    Map<Integer, TreeNode> map = new TreeMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        helper(0, root);
        for(TreeNode node: map.values()){
            ans.add(node.val);
        }
        return ans;
    }
    public void helper(int level, TreeNode root){
        if(root == null) return;
        map.putIfAbsent(level, root);
        if(root.right != null) helper(level + 1, root.right);
        if(root.left != null) helper(level + 1, root.left);
    }
}