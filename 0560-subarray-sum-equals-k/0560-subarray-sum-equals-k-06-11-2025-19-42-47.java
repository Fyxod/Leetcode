class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k) count++;
            }
        }
        return count;
    }
}

//failed attempt to implement optimal
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();

//         int sum = 0;
//         int count = 0;

//         for(int i = 0; i < nums.length; i++){
//             sum += nums[i];
//             if(map.containsKey(sum - k)){
//                 count++;
//             }
//             map.put(sum, i);
//             if(sum - k == 0) count++;
//         }
//         return count;
//     }
// }
// // 1,0
// // 2,1
// // 3,2