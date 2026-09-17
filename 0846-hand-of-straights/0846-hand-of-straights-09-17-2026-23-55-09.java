class Solution {
    public boolean isNStraightHand(int[] hands, int groupSize) {
        int n = hands.length;
        if(n % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int a : hands){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        while(!map.isEmpty()){
            int start = map.firstKey();

            for(int i = start; i < start + groupSize; i++){
                if(!map.containsKey(i)) return false;

                map.put(i, map.get(i) - 1);

                if(map.get(i) == 0) map.remove(i);
            }
        }

        return true;
    }
}