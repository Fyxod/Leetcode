class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int a : stones) pq.offer(a);

        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            if(x != y){
                y = y - x;
                pq.offer(y);
            }
        }
        if(pq.size() == 0) return 0;
        return pq.peek();
    }
}