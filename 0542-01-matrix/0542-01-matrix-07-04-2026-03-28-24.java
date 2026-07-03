class Solution {
    int DIR[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];

        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        int d = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int i = 0; i < 4; i++){
                    int nr = r + DIR[i][0];
                    int nc = c + DIR[i][1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1 || vis[nr][nc]) continue;
                    grid[nr][nc] = d + 1;
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            d++;
        }

        return grid;
    }
}