class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int DIR[][] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        int orig = image[sr][sc];
        image[sr][sc] = color;
        q.offer(new int[]{sr, sc});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int dir[] : DIR){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr < 0 || nc < 0 || nr > m - 1 || nc > n - 1 || image[nr][nc] != orig) continue;
                image[nr][nc] = color;
                q.offer(new int[]{nr, nc});
            }
        }
        return image;
    }
}