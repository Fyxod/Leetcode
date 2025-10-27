class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : hand){
            pq.add(a);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        while(!pq.isEmpty()){
            int a = pq.poll();
            if(map.get(a) != null){
                int size = 0;
                while(size < groupSize){
                    if(map.get(a) != null) size++;
                    else return false;
                    map.put(a, map.get(a) - 1);
                    if(map.get(a) == 0) map.remove(a);
                    a++;
                }
            }

        }
        return true;
    }
}