class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int e[] : flights){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }   

        int dist[][] = new int[n][k + 2];
        for(int arr[] : dist) Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1] == 0 ? a[2] - b[2] : a[1] - b[1]);
        pq.add(new int[]{src, 0, 0});
        dist[src][0] = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int d = curr[1];
            int stops = curr[2];

            if(node == dst) return d;
            if(stops > k) continue;
            if(dist[node][stops] < d) continue;

            for(int f[] : adj.get(node)){
                int city = f[0];
                int cost = f[1];

                if(d + cost < dist[city][stops + 1]){
                    dist[city][stops + 1] = d + cost;
                    pq.offer(new int[]{city, d + cost, stops + 1});
                }
            }
        }
        return -1;
    }
}