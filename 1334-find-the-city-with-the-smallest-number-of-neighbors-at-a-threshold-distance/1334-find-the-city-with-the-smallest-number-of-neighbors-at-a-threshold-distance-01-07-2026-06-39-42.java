class Solution {
    public int findTheCity(int n, int[][] edges, int thresh) {
        int dist[][] = new int[n][n];
        int INF = 1000000000;
        for(int arr[] : dist) Arrays.fill(arr, INF);
        for(int e[] : edges){
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }
        for(int i = 0; i < n; i++) dist[i][i] = 0;
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int a = dist[i][k];
                    int b = dist[k][j];
                    if(a != INF && b != INF && a + b < dist[i][j]) dist[i][j] = a + b;
                }
            }
        }

        int minC = n + 1;
        int min = -1;
        for(int i = 0; i < n; i++){
            int c = 0;
            for(int j = 0; j < n; j++){
                if(dist[i][j] <= thresh) c++;
            }
            if(c <= minC){
                minC = c;
                min = i;
            }
        }
        return min;
    }
}