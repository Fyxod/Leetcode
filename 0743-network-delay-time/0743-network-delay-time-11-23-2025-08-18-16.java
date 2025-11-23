class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int edge[] : times){
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int node = arr[0];
            int time = arr[1];

            if(time > dist[node]) continue;

            for(int[] temp : adj.get(node)){
                int i = temp[0];
                int t = temp[1];

                if(time + t >= dist[i]) continue;
                dist[i] = time + t;
                pq.offer(new int[]{i, time + t});
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}