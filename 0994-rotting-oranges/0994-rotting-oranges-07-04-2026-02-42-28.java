class Solution {
    int DIR[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }
        int t = 0;
        while(!q.isEmpty()){
            int size = q.size();
            t++;
            for(int iter = 0; iter < size; iter++){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int i = 0; i < 4; i++){
                    int nr = r + DIR[i][0];
                    int nc = c + DIR[i][1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return t == 0? 0 : t - 1;
    }
}