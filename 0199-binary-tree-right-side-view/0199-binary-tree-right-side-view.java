// Brute Force
// class Solution {
//     Map<Integer, TreeNode> map = new TreeMap<>();
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if(root == null){
//             return ans;
//         }
//         helper(0, root);
//         for(TreeNode node: map.values()){
//             ans.add(node.val);
//         }
//         return ans;
//     }
//     public void helper(int level, TreeNode root){
//         if(root == null) return;
//         map.putIfAbsent(level, root);
//         if(root.right != null) helper(level + 1, root.right);
//         if(root.left != null) helper(level + 1, root.left);
//     }
// }


class Solution {
    Map<Integer, TreeNode> map = new TreeMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(i == size - 1){
                    ans.add(temp.val);
                }
                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
        }
        return ans;
    }
}
