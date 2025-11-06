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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return helper(map, postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode helper(Map<Integer, Integer> map, int postorder[], int inorder[], int rootIndex, int left, int right){
        TreeNode root = new TreeNode(postorder[rootIndex]);
        int ind = map.get(postorder[rootIndex]);

        if(ind > left){
            root.left = helper(map, postorder, inorder, rootIndex - 1 - (right - ind), left, ind - 1);
        }
        if(ind < right){
            root.right = helper(map, postorder, inorder, rootIndex - 1, ind + 1, right);
        }
        return root;
    }
}