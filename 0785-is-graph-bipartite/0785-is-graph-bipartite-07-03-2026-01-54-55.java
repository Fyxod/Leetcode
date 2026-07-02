class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];

        for(int i = 0; i < n; i++){
            if(color[i] == 0) if(!helper(i, 2, graph, color)) return false;
        }
        return true;
    }
    boolean helper(int node, int par, int[][] graph, int color[]){
        int col = 3 - par;
        color[node] = col;

        for(int nei : graph[node]){
            if(color[nei] == 0){
                if(!helper(nei, col, graph, color)) return false;
            } 
            else if(color[nei] == col) return false;
        }
        return true;
    }
}
