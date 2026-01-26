class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int fullMask = (1 << n) - 1;

        boolean vis[][] = new boolean[fullMask + 1][n];
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            vis[1 << i][i] = true;
            q.offer(new int[]{i, 1 << i});
        }

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int curr[] = q.poll();
                int node = curr[0];
                int mask = curr[1];

                if(mask == fullMask) return steps;
                for(int nei : graph[node]){
                    int nmask = (mask | (1 << nei));
                    if(vis[nmask][nei]) continue;
                    vis[nmask][nei] = true;
                    q.offer(new int[]{nei, nmask});
                }
            }
            steps++;
        }

        return -1;
    }
}