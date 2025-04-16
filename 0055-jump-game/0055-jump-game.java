class Solution {
    public boolean canJump(int[] nums) {
        int index = 0;
        if(nums.length == 1) return true;
        while(nums[index] != 0){
            int maxIndex = index + 1;

            for(int i = 1; i <= nums[index]; i++){
                if(index + i >= nums.length - 1) return true;
                if(nums[maxIndex] <= nums[index + i] || index + i >= nums[maxIndex] + maxIndex){
                    maxIndex = index + i;
                }
            }
            index = maxIndex;
        }
        return false;
    }
}






























//backtracking/memoization solution - TLE at 173/174
// class Solution {
//     public boolean canJump(int[] nums) {
//         return helper(nums, 0);
//     }
//     Map<Integer, Boolean> map = new HashMap<>();

//     boolean helper(int[] arr, int index){
//         if(map.containsKey(index)){
//             return map.get(index);
//         }
//         if(index >= arr.length - 1) return true;
//         if(arr[index] == 0) return false;

//         boolean flag = false;

//         for(int i = 1; i <= arr[index]; i++){
//             flag = flag || helper(arr, index + i);
//             if(flag) break;
//         }
//         map.put(index, flag);
//         return flag;
//     }
// }