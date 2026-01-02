class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(color[i] == 0){
                color[i] = 1;
                q.offer(i);

                while(!q.isEmpty()){
                    int curr = q.poll();
                    int c = color[curr];
                    int oth = c == 1 ? 2 : 1;
                    for(int a : graph[curr]){
                        if(color[a] == c) return false;
                        if(color[a] == 0){
                            color[a] = oth;
                            q.offer(a);
                        }
                    }
                }
            }
        }
        return true;
    }
}