class Solution {
    int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int dist[][] = new int[m][n];

        for(int arr[] : dist) Arrays.fill(arr, Integer.MAX_VALUE / 2);

        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) {
                    dist[i][j] = 0;
                    dfs(i, j, mat, dist, 0, m, n);
                }
            }
        }
        return dist;
    }
    void dfs(int r, int c, int mat[][], int dist[][], int d, int m, int n){
        if(d > dist[r][c]) return;
        
        for(int dir[] : DIR){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= m || nc >= n || nr < 0 || nc < 0 || mat[nr][nc] == 0 || dist[nr][nc] <= d + 1) continue;
            dist[nr][nc] = d + 1;
            dfs(nr, nc, mat, dist, d + 1, m, n);
        }
    }
}