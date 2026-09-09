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
    public int amountOfTime(TreeNode root, int start) {
        Queue<TreeNode> q = new ArrayDeque<>();

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        q.offer(root);

        TreeNode startNode = null;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            TreeNode left = curr.left;
            TreeNode right = curr.right;

            if(curr.val == start) startNode = curr;
            if(left != null){
                parent.put(left, curr);
                q.offer(left);
            }
            if(right != null){
                parent.put(right, curr);
                q.offer(right);
            } 
        }

        q.offer(startNode);
        int minutes = -1;
        Set<Integer> set = new HashSet<>();
        set.add(startNode.val);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode curr = q.poll();

                TreeNode par = parent.get(curr);
                TreeNode left = curr.left;
                TreeNode right = curr.right;

                if(par != null && set.add(par.val)) q.offer(par);
                if(left != null && set.add(left.val)) q.offer(left);
                if(right != null && set.add(right.val)) q.offer(right);
            }
            minutes++;
        }

        return minutes;
    }
}