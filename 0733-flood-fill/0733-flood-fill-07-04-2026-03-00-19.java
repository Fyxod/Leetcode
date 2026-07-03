class Solution {
    int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        int m = image.length;
        int n = image[0].length;
        int orig = image[sr][sc];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++){
                int nr = r + DIR[i][0];
                int nc = c + DIR[i][1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n || image[nr][nc] != orig) continue;
                image[nr][nc] = color;
                q.offer(new int[]{nr, nc});
            }
        }

        return image;
    }
}