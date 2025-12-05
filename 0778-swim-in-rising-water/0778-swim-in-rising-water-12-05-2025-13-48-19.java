class Solution {
    public int swimInWater(int[][] grid) {
        int DIR[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        int times[][] = new int[n][n];

        for(int time[] : times) Arrays.fill(time, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        times[0][0] = grid[0][0];

        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int h = arr[2];

            if(r == n - 1 && c == n - 1) return h;
            if(times[r][c] >= h){

                for(int dir[] : DIR){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < n) {

                        int nh = Math.max(h, grid[nr][nc]);
                        if(times[nr][nc] <= nh) continue;
                        times[nr][nc] = nh;
                        pq.offer(new int[]{nr, nc, nh});
                    }

                }
            }

        }
        return -1;
    }
}