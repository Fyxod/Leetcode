class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean vis[] = new boolean[n];
        int components = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                dfs(stones[i], vis, stones);
                components++;
            }
        }
        return n - components;
    }
    void dfs(int cd[], boolean vis[], int[][] stones){
        int r = cd[0];
        int c = cd[1];

        for(int i = 0; i < stones.length; i++){
            int nr = stones[i][0];
            int nc = stones[i][1];
            if(!vis[i] && (r == nr || c == nc)){
                vis[i] = true;
                dfs(stones[i], vis, stones);
            }
        }
    }
}