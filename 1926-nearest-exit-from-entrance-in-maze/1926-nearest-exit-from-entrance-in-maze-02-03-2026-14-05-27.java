class Solution {
    int m, n;
    int DIR[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{entrance[0], entrance[1]});
        boolean vis[][] = new boolean[m][n];
        vis[entrance[0]][entrance[1]] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int dir[] : DIR){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc] || maze[nr][nc] == '+') continue;
                    if(nr == 0 || nr == m - 1 || nc == 0 || nc == n - 1) return steps + 1;
                    vis[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            steps++;
        }

        return -1;
    }
}