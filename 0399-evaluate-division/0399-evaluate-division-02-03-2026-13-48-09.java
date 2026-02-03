class Solution {
    class Edge{
        double w;
        String v;
        Edge(String v, double w){
            this.w = w;
            this.v = v;
        }
    }
    double ans[];
    Map<String, List<Edge>> map;
    int n, m;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        n = values.length;
        m = queries.size();
        for(int i = 0; i < n; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(new Edge(v, values[i]));
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(new Edge(u, (1.0 / values[i])));
        }
        ans = new double[m];
        for(int i = 0; i < m; i++){
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if(!map.containsKey(u) || !map.containsKey(v)) ans[i] = -1;
            else ans[i] = bfs(u, v);
        }

        return ans;
    }
    double bfs(String u, String v){
        Set<String> vis = new HashSet<>();
        vis.add(u);
        Queue<Edge> q = new ArrayDeque<>();
        q.offer(new Edge(u, 1));
        while(!q.isEmpty()){
            Edge e = q.poll();
            String node = e.v;
            double w = e.w;

            if(node.equals(v)) return w;
            for(Edge nei : map.get(node)){
                String nn = nei.v;
                double cost = nei.w;
                if(!vis.add(nn)) continue;
                q.offer(new Edge(nn, cost * w));
            }
        }

        return -1;
    }
}