/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode leftSide = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSide = lowestCommonAncestor(root.right, p, q);

        if(leftSide == null && rightSide == null) return null;

        // if(leftSide == null){
        //     return rightSide;
        // }
        // else if(rightSide == null){
        //     return leftSide;
        // }
        // else {
        //     return root;
        // }

        return leftSide == null? rightSide : rightSide == null? leftSide : root;
    }
}



//brute force
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if (root == null) {
//             return p;
//         }
//         List<TreeNode> list1 = new LinkedList<>();
//         List<TreeNode> list2 = new LinkedList<>();

//         findPath(root, p, list1);
//         findPath(root, q, list2);

//         Set<TreeNode> set = new HashSet<>(list1);

//         for (TreeNode a : list2) {
//             if (set.contains(a)) {
//                 return a;
//             }
//         }
//         return null;
//     }

//     public boolean findPath(TreeNode root, TreeNode n, List<TreeNode> list) {
//         if (root == null)
//             return false;
//         list.addFirst(root);
//         if (root == n) {
//             return true;
//         }

//         if (findPath(root.left, n, list) || findPath(root.right, n, list))
//             return true;

//         list.remove(0);
//         return false;
//     }
// }