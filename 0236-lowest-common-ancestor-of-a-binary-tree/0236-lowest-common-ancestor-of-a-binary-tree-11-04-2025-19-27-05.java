/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        path1.add(root);
        path2.add(root);
        find(root, p, path1);
        find(root, q, path2);
        TreeNode ans = null;
        
        Set<TreeNode> set = new HashSet(path1);
        for(TreeNode a : path2){
            if(set.contains(a)) ans = a;
        }
        return ans;
    }

    boolean find(TreeNode root, TreeNode p, List<TreeNode> list){
        if(root == null) return false;
        if(root == p) return true;

        list.add(root.left);
        if(find(root.left, p, list)) return true;
        list.remove(list.size() - 1);
        list.add(root.right);
        if(find(root.right, p, list)) return true;
        list.remove(list.size() - 1);
        return false;
    }
}