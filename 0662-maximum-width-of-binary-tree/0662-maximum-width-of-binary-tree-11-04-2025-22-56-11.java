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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        int max = 0;

        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int first = -1;
            int last = -1;

            for(int i = 0; i < size; i++){
                Pair temp = q.poll();
                if(i == 0) first = temp.index;
                if(i == size - 1) last = temp.index;

                if(temp.node.left != null) q.offer(new Pair(temp.node.left, temp.index * 2 + 1));
                if(temp.node.right != null) q.offer(new Pair(temp.node.right, temp.index * 2 + 2));
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}