class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int INF = 1000000000;
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int DIR[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 1});
        int dist[][] = new int[n][n];
        for(int arr[] : dist) Arrays.fill(arr, INF);
        dist[0][0] = 1;

        while(!pq.isEmpty()){
            int curr[] = pq.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(d > dist[r][c]) continue;

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 1 || d + 1 >= dist[nr][nc]) continue;

                dist[nr][nc] = d + 1;
                pq.offer(new int[]{nr, nc, d + 1});
            }
        }

        return dist[n - 1][n - 1] == INF ? -1 : dist[n - 1][n - 1];
    }
}