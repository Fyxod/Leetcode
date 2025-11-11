class Solution {
    int DIR[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1) mark(i, 0, grid, m, n);
            if(grid[i][n - 1] == 1) mark(i, n - 1, grid, m, n);
        }
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 1) mark(0, i, grid, m, n);
            if(grid[m - 1][i] == 1) mark(m - 1, i, grid, m, n);
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) ans++;
            }
        }
        return ans;
    }

    void mark(int r, int c, int[][] grid, int m, int n){
        grid[r][c] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int sr = curr[0];
            int sc = curr[1];
            for(int i = 0; i < DIR.length; i++){
                int nr = sr + DIR[i][0];
                int nc = sc + DIR[i][1];
                if(nr < 0 || nr > m - 1 || nc < 0 || nc > n - 1 || grid[nr][nc] != 1) continue;
                grid[nr][nc] = 0;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}