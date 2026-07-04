class Solution {
    int DIR[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        boolean vis[][] = new boolean[n][n];
        vis[0][0] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        int d = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                if(r == n - 1 && c == n - 1) return d;
                for(int i = 0; i < 8; i++){
                    int nr = r + DIR[i][0];
                    int nc = c + DIR[i][1];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 1 || vis[nr][nc]) continue;
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            d++;
        }
        return -1;
    }
}