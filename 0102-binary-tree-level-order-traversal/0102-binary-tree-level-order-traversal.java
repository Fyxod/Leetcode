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
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode zero = new TreeNode(Integer.MIN_VALUE);
        if(root == null){
            return ans;
        }
        q.offer(root);
        q.offer(zero);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp.val != Integer.MIN_VALUE){
                list.add(temp.val);
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            }
            else {
                ans.add(new ArrayList<>(list));
                list.clear();
                if(!q.isEmpty())
                   q.offer(zero);
            }
        }
        return ans;
    }
}