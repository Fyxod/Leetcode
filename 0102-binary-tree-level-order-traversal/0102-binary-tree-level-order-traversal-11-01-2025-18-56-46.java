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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, 0, list);
        return list;
    }

    void helper(TreeNode root, int level, List<List<Integer>> list){
        if(root == null) return;

        if(level == list.size()) list.add(new ArrayList<>());

        list.get(level).add(root.val);
        helper(root.left, level + 1, list);
        helper(root.right, level + 1, list);
    }
}