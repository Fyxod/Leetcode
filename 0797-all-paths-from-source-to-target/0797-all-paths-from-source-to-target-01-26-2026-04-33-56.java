class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    boolean vis[];
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        vis = new boolean[n];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, list, graph);
        return ans;
    }
    void dfs(int node, List<Integer> list, int[][] graph){
        if(node == n - 1){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int nei : graph[node]){
            if(!vis[nei]){
                vis[nei] = true;
                list.add(nei);
                dfs(nei, list, graph);
                list.remove(list.size() - 1);
                vis[nei] = false;
            }
        }
    }
}