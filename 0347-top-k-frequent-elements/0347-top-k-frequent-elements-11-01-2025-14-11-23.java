class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int a : nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(pq.size() < k || (!pq.isEmpty() && entry.getValue() > pq.peek()[1])){
                pq.add(new int[]{entry.getKey(),  entry.getValue()});
                if(pq.size() > k) pq.poll();
            }
        }

        int ans[] = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = pq.poll()[0];
        }
        return ans;
    }
}