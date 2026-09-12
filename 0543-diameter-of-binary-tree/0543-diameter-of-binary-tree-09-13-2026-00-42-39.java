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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int max = 0;

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();

        Map<TreeNode, Integer> height = new HashMap<>();
        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode curr = stack1.pop();
            stack2.push(curr);

            if(curr.left != null) stack1.push(curr.left);
            if(curr.right != null) stack1.push(curr.right);
        }

        while(!stack2.isEmpty()){
            TreeNode curr = stack2.pop();
            int leftLen = curr.left == null ? 0 : height.get(curr.left);
            int rightLen = curr.right == null ? 0 : height.get(curr.right);

            max = Math.max(max, leftLen + rightLen);

            height.put(curr, 1 + Math.max(leftLen, rightLen));
        }

        return max;
    }
}