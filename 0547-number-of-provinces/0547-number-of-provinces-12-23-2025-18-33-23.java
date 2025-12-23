class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int c = 0;
        boolean vis[] = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                c++;
            }
        }
        return c;
    }
    void dfs(int node, List<List<Integer>> adj, boolean vis[]){
        vis[node] = true;

        for(int nei : adj.get(node)){
            if(!vis[nei]) dfs(nei, adj, vis);
        }
    }
}