class Solution {
    int m, n;
    int DIR[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] || grid2[i][j] == 0 || grid1[i][j] == 0) continue;
                vis[i][j] = true;
                q.offer(new int[]{i, j});
                boolean sub = true;
                while(!q.isEmpty()){
                    int curr[] = q.poll();
                    int r = curr[0];
                    int c = curr[1];
                    for(int dir[] : DIR){
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid2[nr][nc] == 0 || vis[nr][nc]) continue;
                        vis[nr][nc] = true;
                        if(grid1[nr][nc] == 0){
                            sub = false;
                        }
                        q.offer(new int[]{nr, nc});
                    }
                }
                if(sub) ans++;
            }
        }

        return ans;
    }
}