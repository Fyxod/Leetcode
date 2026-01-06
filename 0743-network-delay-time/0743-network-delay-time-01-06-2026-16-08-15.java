class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int t[] : times){
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[k] = 0;
        dist[0] = 0;
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int t = curr[1];

            if(t > dist[node]) continue;

            for(int nei[] : adj.get(node)){
                int nn = nei[0];
                int w = nei[1];

                if(t + w < dist[nn]){
                    dist[nn] = t + w;
                    pq.offer(new int[]{nn, t + w});
                }
            }
        }
        int max = 0;
        for(int a : dist){
            if(a == Integer.MAX_VALUE) return -1;
            max = Math.max(max, a);
        }
        return max;
    }
}