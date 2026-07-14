class Solution {
    ArrayList<Integer>[] adj;
    int answer[];
    int count[];
    int n;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList[n];
        answer = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(0, -1);
        dfs2(0, -1);

        return answer;
    }
    void dfs(int node, int par){
        for(int nei : adj[node]){
            if(nei == par) continue;
            dfs(nei, node);
            answer[node] += answer[nei] + count[nei];
            count[node] += count[nei];
        }
    }
    void dfs2(int node, int par){
        if(par != -1){
            answer[node] = answer[par] - 2 * count[node] + n;
        }
        for(int nei : adj[node]) {
            if(nei == par) continue;
            dfs2(nei, node);
        }
    }
}