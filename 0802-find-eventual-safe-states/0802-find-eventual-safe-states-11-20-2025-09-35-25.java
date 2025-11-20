class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int vis[] = new int[V];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(vis[i] == 2 || (vis[i] == 0 && dfs(i, vis, ans, graph) )) ans.add(i);
        }
        return ans;
    }
    boolean dfs(int node, int vis[], List<Integer> ans, int[][] graph){
        vis[node] = 1;
        boolean flag = true;

        for(int i : graph[node]){
            if(vis[i] == 0){
                flag = flag && dfs(i, vis, ans, graph);
            }
            else if(vis[i] == 1) flag = false;
            if(!flag) break;
        }
        if(flag){
            vis[node] = 2;
            return true;
        }
        return false;
    }
}