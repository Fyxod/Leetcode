class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = mat.length;
        int n = mat[0].length;
        int dist[][] = new int[m][n];

        for(int arr[] : dist) Arrays.fill(arr, Integer.MAX_VALUE / 2);

        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) {
                    q.offer(new int[]{i, j, 0});
                    dist[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            int d = arr[2];

            if(mat[r][c] == 1 && dist[r][c] < d) continue;

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || mat[nr][nc] == 0) continue;
                if(dist[nr][nc] <= d + 1) continue;
                dist[nr][nc] = d + 1;
                q.offer(new int[]{nr, nc, d + 1});
            }
        }
        return dist;
    }
}