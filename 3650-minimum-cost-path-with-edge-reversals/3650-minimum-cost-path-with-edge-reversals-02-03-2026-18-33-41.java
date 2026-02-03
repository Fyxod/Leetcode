class Solution {
    ArrayList<int[]>[] adj;
    public int minCost(int n, int[][] edges) {
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int edge[] : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, 2 * w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(node == n - 1) return d;
            if(d > dist[node]) continue;

            for(int nei[] : adj[node]){
                int nn = nei[0];
                int w = nei[1];
                int nd = w + d;
                if(dist[nn] > nd){
                    dist[nn] = nd;
                    pq.offer(new int[]{nn, nd});
                }
            }
        }

        return -1;
    }
}