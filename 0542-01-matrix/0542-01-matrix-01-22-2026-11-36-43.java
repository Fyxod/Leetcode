class Solution {
    int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        int steps = 1;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int dir[] : DIR){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || mat[nr][nc] == 0 || vis[nr][nc]) continue;
                    vis[nr][nc] = true;
                    mat[nr][nc] = steps;
                    q.offer(new int[]{nr, nc});
                }
            }
            steps++;
        }
        
        return mat;
    }
}