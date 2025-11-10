class Solution {
    class Pair{
        int r;
        int c;
        int min = 0;
        Pair(int r, int c, int min){
            this.r = r;
            this.c = c;
            this.min  = min;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) q.offer(new Pair(i, j, 0));
            }
        }

        int minutes = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int min = curr.min;
            minutes = Math.max(minutes, min);

            if(r > 0 && grid[r - 1][c] != 0 && grid[r - 1][c] != 2){
                grid[r - 1][c] = 2;
                q.offer(new Pair(r - 1, c, min + 1));
            }
            if(c > 0 && grid[r][c - 1] != 0 && grid[r][c - 1] != 2){
                grid[r][c - 1] = 2;
                q.offer(new Pair(r, c - 1, min + 1));
            }
            if(r < m - 1 && grid[r + 1][c] != 0 && grid[r + 1][c] != 2){
                grid[r + 1][c] = 2;
                q.offer(new Pair(r + 1, c, min + 1));
            }
            if(c < n - 1 && grid[r][c + 1] != 0 && grid[r][c + 1] != 2){
                grid[r][c + 1] = 2;
                q.offer(new Pair(r, c + 1, min + 1));
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return minutes;
    }
}