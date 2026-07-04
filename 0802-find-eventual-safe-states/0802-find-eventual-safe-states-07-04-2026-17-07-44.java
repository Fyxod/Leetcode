class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        int in[] = new int[n];
        
        for(int i = 0; i < n; i++){
            in[i] += graph[i].length;
            for(int j : graph[i]){
                adj[j].add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++) if(in[i] == 0) q.offer(i);

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            
            for(int nei : adj[node]){
                in[nei]--;
                if(in[nei] == 0) q.offer(nei);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}