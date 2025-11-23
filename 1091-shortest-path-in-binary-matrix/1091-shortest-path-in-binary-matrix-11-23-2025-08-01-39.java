class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] != 0) return -1;
        int DIR[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        int n = grid.length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1});
        boolean vis[][] = new boolean[n][n];
        vis[0][0] = true;

        while(!q.isEmpty()){
            int arr[] = q.poll();
            int r = arr[0];
            int c = arr[1];
            int length = arr[2];

            if(r == n - 1 && c == n - 1) return length;

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nr > n - 1 || nc > n - 1 || nc < 0 || vis[nr][nc] || grid[nr][nc] != 0) continue;
                vis[nr][nc] = true;
                q.offer(new int[]{nr, nc, length + 1});
            }
        }
        return -1;
    }
}