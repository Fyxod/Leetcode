class Solution {
    int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int INF = Integer.MAX_VALUE / 2;
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, k});
        int dist[][][] = new int[m][n][k + 1];
        for(int arr[][] : dist) for(int arr2[] : arr) Arrays.fill(arr2, INF);
        dist[0][0][k] = 0;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            int kk = curr[3];

            if(d > dist[r][c][kk]) continue;
            if(r == m - 1 && c == n - 1) return d;

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >= 0 && nr < m && nc < n){
                    if(grid[nr][nc] == 1){
                        if(kk > 0 && dist[nr][nc][kk - 1] > d + 1){
                            dist[nr][nc][kk - 1] = d + 1;
                            q.offer(new int[]{nr,nc, d + 1, kk - 1});
                        }
                    }
                    else{
                        if(dist[nr][nc][kk] > d + 1){
                            dist[nr][nc][kk] = d + 1;
                            q.offer(new int[]{nr,nc, d + 1, kk});
                        }
                    }
                }
            } 
        }

        // int min = INF;
        // for(int i = 0; i <= k; i++){
        //     min = Math.min(min, dist[m - 1][n - 1][i]);
        // }

        // return min == INF ? -1 : min;
        return -1;
    }
}