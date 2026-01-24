class Solution {
    int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 1) continue;
                grid[i][j] = -1;
                int cnt = 0;
                q.offer(new int[]{i, j});
                while(!q.isEmpty()){
                    int curr[] = q.poll();
                    int r = curr[0];
                    int c = curr[1];
                    cnt++;

                    for(int dir[] : DIR){
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                        grid[nr][nc] = -1;

                        q.offer(new int[]{nr, nc});
                    }
                }

                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}