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

// HAS_CAMERA = 0;
// COVERED = 1
// NEED_CAMERA = 2
class Solution {
    int INF = 100000000;
    public int minCameraCover(TreeNode root) {
        int res[] = f(root);
        return Math.min(res[0], res[1]);
    }
    int[] f(TreeNode root){
        if(root == null) return new int[]{INF, 0, INF};
        
        int res[] = new int[3];
        int left[] = f(root.left);
        int right[] = f(root.right);
        
        int min = INF;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                min = Math.min(min, left[i] + right[j]);;
            }
        }
        res[0] = 1 + min;
        int case1 = left[0] + Math.min(right[0], right[1]);
        int case2 = right[0] + Math.min(left[0], left[1]);
        int case3 = left[0] + right[0];
        res[1] = Math.min(case1, Math.min(case2, case3));
        res[2] = left[1] + right[1];

        return res;
    } 
}