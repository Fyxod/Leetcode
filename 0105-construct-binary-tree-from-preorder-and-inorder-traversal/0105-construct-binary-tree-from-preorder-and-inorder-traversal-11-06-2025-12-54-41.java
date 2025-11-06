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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        int rootValue = preorder[0];
        int index = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        helper(map, preorder, inorder, 0, root, 0, index - 1, index + 1, inorder.length - 1);
        return root;
    }

    void helper(Map<Integer, Integer> map, int preorder[], int inorder[], int rootIndex, TreeNode root, int leftStart, int leftEnd, int rightStart, int rightEnd){
        int childRootIndex = rootIndex + 1;

        if(childRootIndex < preorder.length){
            int leftRootValue = preorder[childRootIndex];
            int index = map.get(leftRootValue);
            if(index >= leftStart && index <= leftEnd){
                TreeNode leftRoot = new TreeNode(leftRootValue);
                root.left = leftRoot;
                helper(map, preorder, inorder, childRootIndex, leftRoot, leftStart, index - 1, index + 1, leftEnd);
                childRootIndex++;
            }
        }
        if(rightStart <= rightEnd){
            while(childRootIndex < preorder.length){
                int index = map.get(preorder[childRootIndex]);
                if(index >= rightStart && index <= rightEnd) break;
                childRootIndex++;
            }
        }
        if(childRootIndex < preorder.length){
            int rightRootValue = preorder[childRootIndex];
            int index = map.get(rightRootValue);
            if(index >= rightStart && index <= rightEnd){
                TreeNode rightRoot = new TreeNode(rightRootValue);
                root.right = rightRoot;
                helper(map, preorder, inorder, childRootIndex, rightRoot, rightStart, index - 1, index + 1, rightEnd);
            }
        }
    }
}