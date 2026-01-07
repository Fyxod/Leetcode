class Solution {
    int t = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> con) {
        t = 0;
        List<List<Integer>> list = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int time[] = new int[n];
        int low[] = new int[n];
        for(List<Integer> e : con){
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        }
        boolean vis[] = new boolean[n];
        dfs(adj, vis, list, time, low, -1, 0);
        return list;
    }
    void dfs(List<List<Integer>> adj, boolean vis[], List<List<Integer>> list, int time[], int low[], int par, int node){
        vis[node] = true;
        time[node] = t;
        low[node] = t;
        t++;

        for(int nei : adj.get(node)){
            if(nei == par) continue;
            if(!vis[nei]){
                dfs(adj, vis, list, time, low, node, nei);
                low[node] = Math.min(low[node], low[nei]);

                if(low[nei] > time[node]){
                    List<Integer> add = new ArrayList<>();
                    add.add(node); 
                    add.add(nei); 
                    list.add(add);
                }
            }
            else{
                low[node] = Math.min(low[node], time[nei]);
            }
        }
    }
}