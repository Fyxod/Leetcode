class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int INF = 1000000000;
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int DIR[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, 1});

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];

            if(r == n - 1 && c == n - 1) return d;

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= n || grid[nr][nc] == 1) continue;
                grid[nr][nc] = 1;
                q.offer(new int[]{nr, nc, d + 1});
            }
        }

        return -1;
    }
}