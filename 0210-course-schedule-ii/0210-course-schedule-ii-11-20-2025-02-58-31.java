class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        int [] in = new int[V];
        for(int edge[] : edges){
            adj.get(edge[1]).add(edge[0]);
            in[edge[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < V; i++){
            if(in[i] == 0) q.offer(i);
        }
        int ind = 0;
        int ans[] = new int[V];
        while(!q.isEmpty()){
            int curr = q.poll();
            ans[ind++] = curr;
            
            for(int i : adj.get(curr)){
                in[i]--;
                if(in[i] == 0) q.offer(i);
            }
        }
        if(ind != V) return new int[0];
        return ans;
    }
}