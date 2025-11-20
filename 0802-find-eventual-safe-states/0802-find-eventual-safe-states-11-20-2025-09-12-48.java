class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int vis[] = new int[V];
        int path[] = new int[V];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(vis[i] == 0) dfs(i, vis, path, ans, graph);
        }
        Collections.sort(ans);
        return ans;
    }
    boolean dfs(int node, int vis[], int path[], List<Integer> ans, int[][] graph){
        vis[node] = 1;
        path[node] = 1;
        boolean flag = true;

        for(int i : graph[node]){
            if(vis[i] == 0){
                flag = flag && dfs(i, vis, path, ans, graph);
            }
            else if(vis[i] == 1) flag = false;
            if(!flag) break;
        }
        if(flag){
            vis[node] = 2;
            ans.add(node);
            return true;
        }
        return false;
    }
}