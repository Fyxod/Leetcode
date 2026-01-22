class Solution {
    int DIR[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    for(int dir[] : DIR){
                        int nr = i + dir[0];
                        int nc = j + dir[1];

                        if(nr < 0 || nc < 0 || nr >= n || nc >= m || grid[nr][nc] == 0) ans++;
                    }
                }
            }
        }

        return ans;
    }
}