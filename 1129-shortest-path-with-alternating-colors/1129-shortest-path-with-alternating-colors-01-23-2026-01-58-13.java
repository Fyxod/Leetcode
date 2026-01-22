class Solution {
    int INF = Integer.MAX_VALUE / 2;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Integer>[] adjB = new ArrayList[n];
        ArrayList<Integer>[] adjR = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adjB[i] = new ArrayList<>();
            adjR[i] = new ArrayList<>();
        }

        for(int edge[] : redEdges){
            adjR[edge[0]].add(edge[1]);
        }
        for(int edge[] : blueEdges){
            adjB[edge[0]].add(edge[1]);
        }

        int dist[][] = new int[2][n];
        for(int arr[] : dist) Arrays.fill(arr, INF);
        dist[0][0] = 0;
        dist[1][0] = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1});

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int curr[] = q.poll();
                int node = curr[0];
                int color = curr[1];

                if(color == 0){
                    for(int nei : adjR[node]){
                        if(dist[1][nei] == INF){
                            dist[1][nei] = steps + 1;
                            q.offer(new int[]{nei, 1});
                        }
                    }
                }
                else{
                    for(int nei : adjB[node]){
                        if(dist[0][nei] == INF){
                            dist[0][nei] = steps + 1;
                            q.offer(new int[]{nei, 0});
                        }
                    }
                }
            }
            steps++;
        }

        for(int i = 0; i < n; i++){
            dist[0][i] = Math.min(dist[0][i], dist[1][i]);
            if(dist[0][i] == INF) dist[0][i] = -1;
        }

        return dist[0];
    }
}