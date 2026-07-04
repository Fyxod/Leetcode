class Solution {
    int INF = Integer.MAX_VALUE / 2;
    int DIR[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int minimumEffortPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dist[][] = new int[m][n];
        for(int arr[] : dist) Arrays.fill(arr, INF);
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(r == m - 1 && c == n - 1) return d;
            if(d > dist[r][c]) continue;
            for(int i = 0; i < 4; i++){
                int nr = r + DIR[i][0];
                int nc = c + DIR[i][1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int nd = Math.max(Math.abs(grid[r][c] - grid[nr][nc]), d);
                if(dist[nr][nc] <= nd) continue;
                dist[nr][nc] = nd;
                pq.offer(new int[]{nr, nc, nd});
            }
        }

        return -1;
    }
}