class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n == 1) return 0;
        int fullMask = (1 << n) - 1;
        boolean vis[][] = new boolean[n][1 << n];

        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int mask = 1 << i;
            q.offer(new int[]{i, mask});
            vis[i][mask] = true;
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
                    int nmask = mask | (1 << nei);
                    if(!vis[nei][nmask]){
                        vis[nei][nmask] = true;
                        q.offer(new int[]{nei, nmask});
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}