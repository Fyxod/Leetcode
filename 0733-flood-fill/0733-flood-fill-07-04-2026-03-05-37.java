class Solution {
    int DIR[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        m = image.length;
        n = image[0].length;
        int orig = image[sr][sc];

        image[sr][sc] = color;

        dfs(image, sr, sc, orig, color);

        return image;
    }
    void dfs(int image[][], int r, int c, int orig, int color){

        for(int i = 0; i < 4; i++){
            int nr = r + DIR[i][0];
            int nc = c + DIR[i][1];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n || image[nr][nc] != orig) continue;
            image[nr][nc] = color;
            dfs(image, nr, nc, orig, color);
        }
    }
}