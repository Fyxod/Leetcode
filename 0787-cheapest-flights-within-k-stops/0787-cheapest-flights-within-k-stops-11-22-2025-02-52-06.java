class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int dist[][] = new int[n][k + 2];
        for(int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int flight[] : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[src][0] = 0;
        pq.offer(new int[]{src, 0, 0});

        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int curr = arr[0];
            int d = arr[1];
            int stops = arr[2];

            if(curr == dst) return d;
            if(k + 1 == stops) continue;

            for(int nei[] : adj.get(curr)){
                int node = nei[0];
                int price = nei[1];

                if(d + price < dist[node][stops + 1]){
                    dist[node][stops + 1] = d + price;
                    pq.offer(new int[]{node, d + price, stops + 1});
                }
            }
        }
        return -1;
    }
}