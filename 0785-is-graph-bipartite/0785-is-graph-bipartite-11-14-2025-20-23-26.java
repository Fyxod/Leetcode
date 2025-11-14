class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(color[i] != -1) continue;
            q.add(i);
            while(!q.isEmpty()){
                int curr = q.poll();
                if(color[curr] == -1) color[curr] = 0;

                for(int neig : graph[curr]){
                    if(color[neig] == -1){
                        color[neig] = color[curr] ^ 1;
                        q.add(neig);
                    }
                    else if(color[neig] == color[curr]) return false;
                }
            }
        }
        return true;
    }
}