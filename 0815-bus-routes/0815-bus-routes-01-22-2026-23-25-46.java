class Solution {
    public int numBusesToDestination(int[][] routes, int src, int target) {
        if(src == target) return 0;
        int n = routes.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean vis[] = new boolean[n];
        for(int i = 0; i < n; i++){
            for(int node : routes[i]){
                map.computeIfAbsent(node, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        if(!map.containsKey(src)) return -1;
        for(int bus : map.get(src)){
            q.offer(bus);
        }

        int buses = 1;
        
        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int curr = q.poll();
                if(vis[curr]) continue;
                vis[curr] = true;
                for(int nei : routes[curr]){
                    if(nei == target) return buses;
                    for(int bus : map.get(nei)){
                        if(!vis[bus]) q.offer(bus);
                    }
                }
            }
            buses++;
        }

        return -1;
    }
}