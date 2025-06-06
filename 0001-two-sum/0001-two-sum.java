class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for(int i = 1; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.putIfAbsent(nums[i], i);
        }
        return new int[]{0,1};
    }
}






















//earlier
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int arr[] = new int[2];
//         Map<Integer, Integer> map = new HashMap<>();

//         for(int i = 0; i < nums.length; i++){
//             if(map.containsKey(nums[i])){
//                 arr[0] = map.get(nums[i]);
//                 arr[1] = i;
//             }
//             map.put(target-nums[i], i);
//         }
//         return arr;
//     }
// }