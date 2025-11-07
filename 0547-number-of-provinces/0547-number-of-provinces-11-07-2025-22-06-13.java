class Solution {
    public int findCircleNum(int[][] isConnected) {
        int prov = 0;
        boolean vis[] = new boolean[isConnected.length];

        for(int i = 0; i < isConnected.length; i++){
            if(!vis[i]){
                prov++;
                dfs(i, vis, isConnected);
            }
        }
        return prov;
    }
    void dfs(int node, boolean vis[], int[][] isConnected){
        vis[node] = true;

        for(int i = 0; i < isConnected[node].length; i++){
            if(node != i && isConnected[node][i] == 1 && !vis[i]) dfs(i, vis, isConnected);
        }
    }
}