class Solution {
    int INF = Integer.MAX_VALUE / 2;
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        k++;
        ArrayList<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for(int edge[] : edges){
            adj[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0, 0});
        int dist[][] = new int[n][k + 1];
        for(int arr[] : dist) Arrays.fill(arr, INF);
        dist[src][0] = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];
            
            if(node == dst) return cost;
            if(stops >= k || dist[node][stops] < cost) continue;

            for(int nei[] : adj[node]){
                int nn = nei[0];
                int c = nei[1];

                if(dist[nn][stops + 1] > cost + c){
                    dist[nn][stops + 1] = cost + c;
                    pq.offer(new int[]{nn, cost + c, stops + 1});
                }
            }
        }

        return -1;
    }
}