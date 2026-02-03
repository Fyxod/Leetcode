class Solution {
    final int DIR[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean fresh = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                else if(grid[i][j] == 1) fresh = true;
            }
        }

        if(!fresh) return 0;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean yes = false;
            while(size-- > 0){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int dir[] : DIR){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    yes = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            if(yes) steps++;
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return steps;
    }
}