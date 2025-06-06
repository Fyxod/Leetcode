class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        for(int a : nums){
            if(a == 1){
                curr++;
            }
            else {
                max = Math.max(curr, max);
                curr = 0;
            }
        }
        max = Math.max(curr, max);
        return max;
    }
}





















































// class Solution {
//     public int findMaxConsecutiveOnes(int[] nums) {
//         int max = 0;
//         int current = 0;

//         for(int a: nums){
//             if(a != 1){
//                 current = 0;
//             }
//             else{
//             current++;
//             max = Math.max(current, max);
//             }
//         }
//         return max;
//     }
// }