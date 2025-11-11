class Solution {
    class Node{
        int r;
        int c;
        int dist;

        Node(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<Node> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            Node curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int dist = curr.dist;

            if(r > 0 && !vis[r - 1][c]){
                res[r - 1][c] = dist + 1;
                vis[r - 1][c] = true;
                q.offer(new Node(r - 1, c, dist + 1)); 
            }
            if(r < m - 1 && !vis[r + 1][c]){
                res[r + 1][c] = dist + 1;
                vis[r + 1][c] = true;
                q.offer(new Node(r + 1, c, dist + 1)); 
            }
            if(c > 0 && !vis[r][c - 1]){
                res[r][c - 1] = dist + 1;
                vis[r][c - 1] = true;
                q.offer(new Node(r, c - 1, dist + 1)); 
            }
            if(c < n - 1 && !vis[r][c + 1]){
                res[r][c + 1] = dist + 1;
                vis[r][c + 1] = true;
                q.offer(new Node(r, c + 1, dist + 1)); 
            }
        }
        return res;
    }
}