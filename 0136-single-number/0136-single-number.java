class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int a: nums){
            map.put(a, map.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
}