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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder targetP = new StringBuilder();;
        StringBuilder path = new StringBuilder();
        dfs(root, target, k, path, targetP, map);
        List<Integer> list = new ArrayList<>();
        String p = targetP.toString();
        for(String a : map.keySet()){
            if(distance(p, a, k) == k) list.add(map.get(a));
        }
        return list;
    }
    void dfs(TreeNode root, TreeNode target, int k, StringBuilder path, StringBuilder targetP, Map<String, Integer> map){
        if(root == null) return;
        if(root == target || root.val == target.val) targetP.append(path);
        map.put(path.toString(), root.val);

        path.append("l");
        dfs(root.left, target, k, path, targetP, map);
        path.deleteCharAt(path.length() - 1);
        path.append("r");
        dfs(root.right, target, k, path, targetP, map);
        path.deleteCharAt(path.length() - 1);
    }

    int distance(String a, String b, int k){
        int i = 0;
        int dist = 0;
        while(i < a.length() && i < b.length() && a.charAt(i) == b.charAt(i)) i++;
        // System.out.println(i);
        while(i < a.length() || i < b.length()){
            if(i < a.length() && i < b.length()) dist+=2;
            else dist++;
            i++;
        }
        return dist;
    }
}