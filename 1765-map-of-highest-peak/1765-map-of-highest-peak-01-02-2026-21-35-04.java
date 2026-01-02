class Solution {
    public int[][] highestPeak(int[][] w) {
        int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int m = w.length;
        int n = w[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(w[i][j] == 1) {
                    w[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
                else w[i][j] = -1;
            }
        }

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            int d = w[r][c];

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nc >= 0 && nc < n && nr < m && w[nr][nc] == -1){
                    w[nr][nc] = d + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return w;
    }
}