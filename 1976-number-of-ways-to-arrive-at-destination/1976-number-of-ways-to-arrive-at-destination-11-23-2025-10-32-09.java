class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int edge[] : roads){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});

        long dist[] = new long[n];
        long ways[] = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        while(!pq.isEmpty()){
            long arr[] = pq.poll();
            int node = (int)arr[0];
            long time = arr[1];

            if(time > dist[node]) continue;

            for(int[] temp : adj.get(node)){
                int i = temp[0];
                int t = temp[1];

                long nt = time + t;
                if(nt < dist[i]){
                    dist[i] = nt;
                    ways[i] = ways[node];
                    pq.offer(new long[]{i, nt});
                }
                else if(nt == dist[i]){
                    ways[i] = (ways[i] + ways[node]) % MOD;
                }
            }
        }
        return (int)ways[n - 1];
    }
}