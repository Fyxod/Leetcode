class Solution {
    class Pair{
        int r;
        int c;

        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int orig = image[sr][sc];
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(sr, sc));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            image[r][c] = color;
            if(r > 0 && image[r - 1][c] == orig) q.offer(new Pair(r - 1, c));
            if(r < image.length - 1 && image[r + 1][c] == orig) q.offer(new Pair(r + 1, c));
            if(c < image[0].length - 1 && image[r][c + 1] == orig) q.offer(new Pair(r, c + 1));
            if(c > 0 && image[r][c - 1] == orig) q.offer(new Pair(r, c - 1));
        }
        return image;
    }
}