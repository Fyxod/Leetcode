class Solution {
    int INF = Integer.MAX_VALUE / 2;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return 0;
        k++;
        ArrayList<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int f[] : flights){
            adj[f[0]].add(new int[]{f[1], f[2]});
        }

        int dist[][] = new int[k + 2][n];
        for(int arr[] : dist) Arrays.fill(arr, INF);
        dist[0][src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{src, 0, 0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int d = curr[1];
            int stops = curr[2];

            if(node == dst) return d;
            if(d > dist[stops][node] || stops >= k) continue;

            for(int nei[] : adj[node]){
                int nn = nei[0];
                int cost = nei[1];

                if(d + cost < dist[stops + 1][nn]){
                    dist[stops + 1][nn] = d + cost;
                    pq.offer(new int[]{nn, dist[stops + 1][nn], stops + 1});
                }
            }
        }
        return -1;
    }
}