class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a:nums){
            if(map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            }
            else{
                map.put(a, 0);
            }
        }
        int sum = 0;
        for(int a: map.keySet()){
            if(map.get(a) == 0){
                sum = sum + a;
            }
        }
        return sum;
    }
}