class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];

        for(int i = 0; i < n; i++){
            if(color[i] == 0) color[i] = 1;
            int c = color[i];
            int oth = c == 1 ? 2 : 1;
            for(int a : graph[i]){
                if(color[a] == c) return false;
                color[a] = oth;
            }
        }
        return true;
    }
}