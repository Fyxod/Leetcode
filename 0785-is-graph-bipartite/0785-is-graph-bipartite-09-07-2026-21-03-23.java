class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        
        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                color[i] = 1;
                if(!dfs(color, i, graph)) return false;
            }
        }

        return true;
    }
    boolean dfs(int color[], int node, int graph[][]){
        int col = color[node];
        int other = 3 - color[node];

        for(int nei : graph[node]){
            if(color[nei] == 0){
                color[nei] = other;
                if(!dfs(color, nei, graph)) return false;
            }
            else if(color[nei] == col) return false;
        }

        return true;
    }
}