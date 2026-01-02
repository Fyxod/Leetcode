class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        List<Integer> list = new ArrayList<>();
        int in[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int a : graph[i]){
                adj.get(a).add(i);
                in[i]++;
            }
        }

        for(int i = 0; i < n; i++) if(in[i] == 0) dfs(adj, in, i, list);
        Collections.sort(list);
        return list;
    }
    void dfs(List<List<Integer>> adj, int in[], int node, List<Integer> list){
        list.add(node);

        for(int a : adj.get(node)){
            in[a]--;
            if(in[a] == 0) {
                in[a] = -1;
                dfs(adj, in, a, list);
            }
        }
    }
}