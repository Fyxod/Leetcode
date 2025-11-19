class Solution {
    public boolean canFinish(int V, int[][] edges) {
        boolean vis[] = new boolean[V];
        boolean path[] = new boolean[V];
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < V; i++){
            if(!vis[i] && !dfs(i, adj, vis, path)) return false;
        }
        return true;
    }
    boolean dfs(int node,  List<List<Integer>> adj, boolean vis[], boolean path[]){
        path[node] = true;
        vis[node] = true;
        
        for(int i : adj.get(node)){
            if(!vis[i]){
                if(!dfs(i, adj, vis, path)) return false;
            }
            else if(path[i]) return false;
        }
        path[node] = false;
        return true;
    }
}