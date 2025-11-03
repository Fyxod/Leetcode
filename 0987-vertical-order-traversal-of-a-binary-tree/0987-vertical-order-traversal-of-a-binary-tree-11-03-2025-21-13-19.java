/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    Map<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new HashMap<>();
    int minLevel = 0;
    int maxLevel = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        helper(root, 0, 0);
        for(int i = minLevel; i <= maxLevel; i++){
            Map<Integer, ArrayList<Integer>> currLevel = map.get(i);
            List<Integer> temp = new ArrayList<>(); 
            for(List<Integer> list: currLevel.values()){
                Collections.sort(list);
                temp.addAll(list);
            }
                ans.add(temp);
        }
        return ans;
    }

    public void helper(TreeNode root, int rootLevel, int row) {

        if(map.containsKey(rootLevel)){
            Map<Integer, ArrayList<Integer>> currLevel = map.get(rootLevel);
            // currLevel.add(root.val);
            if(currLevel.containsKey(row)){
                List<Integer> currRow =currLevel.get(row);
                currRow.add(root.val);
            }
            else{
              currLevel.put(row, new ArrayList<>(Arrays.asList(root.val)));
            }
        }
        else{
            map.put(rootLevel, new TreeMap <Integer, ArrayList<Integer>>(){{
                    put(row, new ArrayList<>(Arrays.asList(root.val)));
        }});
        
        }

        if (root.left != null) {
            helper(root.left, rootLevel - 1, row + 1);
            minLevel = Math.min(minLevel, rootLevel - 1);
        }

        if (root.right != null) {
            helper(root.right, rootLevel + 1, row + 1);
            maxLevel = Math.max(maxLevel, rootLevel + 1);
        }

    }
}