class Solution {
    int m, n;
    int DIR[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int islands = 0;
        m = grid.length;
        n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    islands++;
                }
                
            }
        }
        return islands;
    }
    void dfs(int rr, int cc, char grid[][]){
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{rr, cc});
        grid[rr][cc] = '0';

        while(!stack.isEmpty()){
            int curr[] = stack.pop();
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 4; i++){
                int nr = r + DIR[i][0];
                int nc = c + DIR[i][1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != '1') continue;
                grid[nr][nc] = '0';
                stack.push(new int[]{nr, nc});
            }
        }
    }
}