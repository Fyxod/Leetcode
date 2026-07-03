class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean vis[] = new boolean[n];
        int cnt = 0;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int edge[] : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                List<Integer> nodes = new ArrayList<>();
                dfs(vis, adj, i, nodes);
                if(check(nodes, adj)) cnt++;
            }
        }

        return cnt;
    }
    void dfs(boolean vis[], ArrayList<Integer>[] adj, int node, List<Integer> nodes){
        vis[node] = true;
        nodes.add(node);

        for(int nei : adj[node]){
            if(!vis[nei]) dfs(vis, adj, nei, nodes);
        }
    }
    boolean check(List<Integer> nodes, ArrayList<Integer>[] adj){
        int edges = 0;
        for(int node : nodes){
            edges += adj[node].size();
        }
        return edges == nodes.size() * (nodes.size() - 1);
    }
}
