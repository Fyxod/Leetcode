class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int in[] = new int[n];

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int arr[] : pre){
            adj.get(arr[1]).add(arr[0]);
            in[arr[0]]++;
        }

        int ans[] = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) if(in[i] == 0) q.offer(i);
        int i = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[i++] = curr;

            for(int nei : adj.get(curr)){
                in[nei]--;
                if(in[nei] == 0) q.offer(nei);
            }
        }
        return ans;
    }
}