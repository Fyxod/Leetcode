class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int vis[] = new int[numCourses];
        //0 = unvisited
        //1 = visited
        //2 = completed

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int a[] : prerequisites){
            adj.get(a[0]).add(a[1]);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            if(vis[i] != 0) continue;
            if(!dfs(i, adj, vis, ans)) return new int[0];
        }
        if(ans.size() != numCourses) return new int[0];
        int arr[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            arr[i] = ans.get(i);
        }

        return arr;
    }
    boolean dfs(int node, List<List<Integer>> adj, int[] vis, List<Integer> ans){
        if(vis[node] == 2) return true;
        vis[node] = 1;
        if(adj.get(node).size() == 0){
            ans.add(node);
            vis[node] = 2;
            return true;
        }
        boolean flag = false;
        for(int ne : adj.get(node)){
            if(vis[ne] == 1) return false;
            flag = dfs(ne, adj, vis, ans);
        }
        if(flag){
            ans.add(node);
            vis[node] = 2;
        }
        return flag;
    }
}