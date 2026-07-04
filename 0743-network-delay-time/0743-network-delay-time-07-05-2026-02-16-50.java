class Solution {
    int INF = Integer.MAX_VALUE / 2;
    public int networkDelayTime(int[][] edges, int n, int k) {
        ArrayList<int[]> adj[] = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for(int edge[] : edges){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        int dist[] = new int[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{k, 0});
        dist[k] = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(d > dist[node]) continue;
            for(int nei[] : adj[node]){
                int nn = nei[0];
                int c = nei[1];

                if(d + c < dist[nn]){
                    dist[nn] = d + c;
                    pq.offer(new int[]{nn, dist[nn]});
                }
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++){
            int a = dist[i];
            if(a == INF) return -1;
            ans = Math.max(ans, a);
        }

        return ans;
    }
}