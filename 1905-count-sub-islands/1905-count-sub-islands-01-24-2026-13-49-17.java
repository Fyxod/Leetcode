class Solution {
    int par[];
    int m, n, tot;
    int DIR[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        tot = m * n;
        par = new int[tot];
        for(int i = 0; i < tot; i++) par[i] = i;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid1[i][j] == 0) continue;
                int id = i * n + j;
                for(int dir[] : DIR){
                    int nr = i + dir[0];
                    int nc = j + dir[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid1[nr][nc] == 0) continue;
                    int nid = nr * n + nc;
                    union(id, nid);
                }
            }
        }

        int ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean vis[][] = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(vis[i][j] || grid2[i][j] == 0 || grid1[i][j] == 0) continue;
                vis[i][j] = true;
                int match = find(i * n + j);
                q.offer(new int[]{i, j});
                boolean sub = true;
                // System.out.println("iteration");
                while(!q.isEmpty()){
                    int curr[] = q.poll();
                    int r = curr[0];
                    int c = curr[1];
                    // System.out.println(r + " " + c + " " + sub);
                    for(int dir[] : DIR){
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid2[nr][nc] == 0 || vis[nr][nc]) continue;
                        vis[nr][nc] = true;
                        if(grid1[nr][nc] == 0 || find(nr * n + nc) != match){
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
    int find(int x){
        if(x == par[x]) return x;
        return par[x] = find(par[x]);
    }
    void union(int x, int y){
        int par1 = find(x);
        int par2 = find(y);
        if(par1 == par2) return;
        par[par1] = par2;
    }
}