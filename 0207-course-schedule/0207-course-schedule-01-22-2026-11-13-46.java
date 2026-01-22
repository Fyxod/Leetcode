class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        int in[] = new int[n];

        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int pre[] : prerequisites){
            int u = pre[0];
            int v = pre[1];

            adj[u].add(v);
            in[v]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) if(in[i] == 0) q.offer(i);

        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;

            for(int nei : adj[node]){
                in[nei]--;
                if(in[nei] == 0) q.offer(nei);
            }
        }

        return cnt == n;
    }
}