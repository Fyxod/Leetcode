class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isConnected[i][j] == 1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        int cnt = 0;
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                vis[i] = true;
                bfs(i, vis, adj);
                cnt++;
            }
        }

        return cnt;
    }
    void bfs(int node, boolean vis[], ArrayList<Integer>[] adj){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()){
            int nn = q.poll();
            for(int nei : adj[nn]){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
}