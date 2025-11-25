class Solution {
    public int findTheCity(int n, int[][] edges, int d) {
        int grid[][] = new int[n][n];
        int INF = Integer.MAX_VALUE;

        for(int node[] : grid) Arrays.fill(node, INF);
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            grid[u][v] = w;
            grid[v][u] = w;
        }

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int a = grid[i][k];
                    int b = grid[k][j];
                    if(a != INF && b != INF && a + b < grid[i][j]){
                        grid[i][j] = a + b;
                    }
                }
            }
        }

        int node = -1;
        int nodeCount = INF;

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j && grid[i][j] <= d) count++;
            }
            if(count <= nodeCount){
                nodeCount = count;
                node = i;
            }
        }
        return node;
    }
}