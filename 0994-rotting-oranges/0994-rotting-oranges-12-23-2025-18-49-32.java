class Solution {
    class Pair{
        int r;
        int c;
        int time;

        Pair(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int DIR[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Pair> q = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int max = 0;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int t = curr.time;
            max = Math.max(max, t);
            for(int dir[]: DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr > n - 1 || nc > m - 1 || grid[nr][nc] != 1) continue;
                grid[nr][nc] = 2;
                q.offer(new Pair(nr, nc, t + 1));
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return max;
    }
}