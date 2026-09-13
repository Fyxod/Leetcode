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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;

            if(list.size() == row) list.add(node.val);
            else list.set(row, node.val);

            if(node.left != null) q.offer(new Pair(node.left, row + 1));
            if(node.right != null) q.offer(new Pair(node.right, row + 1));
        }

        return list;
    }
    class Pair{
        TreeNode node;
        int row;

        Pair(TreeNode node, int row){
            this.node = node;
            this.row = row;
        }
    }
}