class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int req = n >> 1;
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() == req) return e.getKey();
        }
        return -1;
    }
}