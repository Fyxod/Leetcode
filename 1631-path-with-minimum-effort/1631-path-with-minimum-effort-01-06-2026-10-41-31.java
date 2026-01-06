class Solution {
    public int minimumEffortPath(int[][] h) {
        int m = h.length;
        int n = h[0].length;
        int DIR[][] = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};

        int dist[][] = new int[m][n];
        for(int a[] : dist) Arrays.fill(a, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(r == m - 1 && c == n - 1) return d;
            if(d > dist[r][c]) continue;

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int cost = Math.max(d, Math.abs(h[r][c] - h[nr][nc]));
                if(dist[nr][nc] > cost){
                    dist[nr][nc] = cost;
                    pq.add(new int[]{nr, nc, cost});
                }
            }
        }
        return -1;
    }
}