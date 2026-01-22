class Solution {
    int DIR[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row, col});
        int orig = grid[row][col];
        grid[row][col] = -1;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || 
                    (grid[nr][nc] > 0 && grid[nr][nc] != orig)) grid[r][c] = -2;
                else if(grid[nr][nc] == orig){
                    grid[nr][nc] = -1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == -1) grid[i][j] = orig;
                else if(grid[i][j] == -2) grid[i][j] = color;
            }
        }

        return grid;
    }
}