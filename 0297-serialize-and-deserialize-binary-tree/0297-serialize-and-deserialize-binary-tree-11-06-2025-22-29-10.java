/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        str.append(root.val).append("#");

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();

                if(curr.left != null){
                    q.offer(curr.left);
                    str.append(curr.left.val).append("#");
                }
                else str.append("n#");

                if(curr.right != null){
                    q.offer(curr.right);
                    str.append(curr.right.val).append("#");
                }
                else str.append("n#");
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        int count = 0;
        String arr[] = data.split("#");
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        q.offer(root);
        int index = 1;

        while(!q.isEmpty() && index < arr.length){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(index > arr.length - 1) break;
                String left = arr[index++];
                if(!left.equals("n")) temp.left = new TreeNode(Integer.valueOf(left));
                if(index > arr.length - 1) break;
                String right = arr[index++];
                if(!right.equals("n")) temp.right = new TreeNode(Integer.valueOf(right));

                if(temp.left != null) q.offer(temp.left);
                if(temp.right != null) q.offer(temp.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));