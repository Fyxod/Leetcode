class Solution {
    ArrayList<Integer>[] adj;
    int n;
    int color[];
    public boolean possibleBipartition(int nn, int[][] dislikes) {
        n = nn;
        color = new int[n + 1];
        adj = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for(int dis[] : dislikes){
            int u = dis[0], v = dis[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            if(color[i] == 0){
                color[i] = 1;
                q.offer(i);


                while(!q.isEmpty()){
                    int node = q.poll();
                    int col = color[node];
                    int oth = 3 - col;
                    for(int nei : adj[node]){
                        if(color[nei] == 0){
                            color[nei] = oth;
                            q.offer(nei);
                        }
                        else if(color[nei] == col) return false;
                    }
                }


            }
        }

        return true;
    }
}