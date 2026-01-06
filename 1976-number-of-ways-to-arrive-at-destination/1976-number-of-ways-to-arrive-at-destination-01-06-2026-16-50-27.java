class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1000000007;
        long dist[][] = new long[n][2];
        for(long arr[] : dist) arr[0] = Long.MAX_VALUE;
        dist[0][0] = 0;
        dist[0][1] = 1;

        List<List<long[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int r[] : roads){
            adj.get(r[0]).add(new long[]{r[1], r[2]});
            adj.get(r[1]).add(new long[]{r[0], r[2]});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.add(new long[]{0, 0});

        while(!pq.isEmpty()){
            long curr[] = pq.poll();
            int node = (int)curr[0];
            long d = curr[1];
            long ways = dist[node][1];

            if(d > dist[node][0]) continue;

            for(long nei[] : adj.get(node)){
                int nn = (int)nei[0];
                long w = nei[1];

                if(d + w > dist[nn][0]) continue;
                if(d + w == dist[nn][0]) dist[nn][1] = (dist[nn][1] + ways) % MOD;
                else{
                    dist[nn][0] = d + w;
                    dist[nn][1] = ways;
                    pq.offer(new long[]{nn, d + w});
                }
            }
        }
        return (int)dist[n - 1][1];
    }
}