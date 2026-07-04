class Solution {
    int MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {
        ArrayList<int[]> adj[] = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int edge[] : roads){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
            adj[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        long dist[][] = new long[n][2];
        for(long arr[] : dist) arr[0] = Long.MAX_VALUE / 2;
        dist[0][0] = 0;
        dist[0][1] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()){
            long curr[] = pq.poll();
            int node = (int)curr[0];
            long cost = curr[1];

            if(cost > dist[node][0]) continue;

            for(int nei[] : adj[node]){
                int nn = (int)nei[0];
                long c = nei[1];

                if(cost + c > dist[nn][0]) continue;
                if(cost + c < dist[nn][0]){
                    dist[nn][0] = cost + c;
                    dist[nn][1] = dist[node][1];
                    pq.offer(new long[]{nn, cost + c});
                }
                else{
                    dist[nn][1] = (dist[nn][1] + dist[node][1]) % MOD;
                }
            }
        }

        return (int)dist[n - 1][1];
    }
}