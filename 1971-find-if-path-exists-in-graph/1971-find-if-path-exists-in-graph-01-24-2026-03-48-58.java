class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;

        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }
        boolean vis[] = new boolean[n];
        return dfs(adj, vis, source, destination);
    }
    boolean dfs(ArrayList<Integer>[] adj, boolean vis[], int node, int d){
        if(node == d) return true;
        if(vis[node]) return false;

        vis[node] = true;

        for(int nei : adj[node]){
            if(dfs(adj, vis, nei, d)) return true;
        }

        return false;
    }
}