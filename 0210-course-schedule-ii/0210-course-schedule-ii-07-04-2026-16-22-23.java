class Solution {
    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int in[] = new int[n];
        for(int edge[] : edges){
            adj.get(edge[1]).add(edge[0]);
            in[edge[0]]++;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++) if(in[i] == 0) stack.push(i);

        int ans[] = new int[n];
        int ind = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            ans[ind++] = node;

            for(int nei : adj.get(node)){
                in[nei]--;
                if(in[nei] == 0) stack.push(nei);
            }
        }

        if(ind != n) return new int[0];
        return ans;
    }
}