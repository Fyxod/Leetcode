class Solution {
    public int minimumEffortPath(int[][] heights) {
        int DIR[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = heights.length;
        int n = heights[0].length;
        int diff[][] = new int[m][n];
        for(int i[] : diff) Arrays.fill(i, Integer.MAX_VALUE);
        diff[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int arr[] = pq.poll();
            int r = arr[0];
            int c = arr[1];
            int d = arr[2];

            if(r == m - 1 && c == n - 1) return d;
            if(d > diff[r][c]) continue;

            for(int i = 0; i < 4; i++){
                int nr = r + DIR[i][0];
                int nc = c + DIR[i][1];
                if(nr < 0 || nr > m - 1 || nc < 0 || nc > n - 1) continue;

                int abs = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));

                if(diff[nr][nc] <= abs) continue;
                diff[nr][nc] = abs;
                pq.offer(new int[]{nr, nc, abs});
            }
        }
        return 0;
    }
}