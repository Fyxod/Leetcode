class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int temp = nums[0];
        for(int a : nums){
            if(temp == a){
                count++;
            }
            else if(count == 0){
                temp = a;
                count++;
            }
            else{
                count--;
            }
            if(count > nums.length / 2) return temp;
        }
        return temp;
    }
}






























































// class Solution {
//     public int majorityElement(int[] nums) {
//         int count = 0;
//         int ans = nums[0];

//         for(int a : nums){
//             if(count == 0){
//                 ans = a;
//                 count++;
//             }
//             else if(ans == a){
//                 count++;
//             }
//             else{
//                 count--;
//             }
//         }
//         return ans;
//     }
// }

// class Solution {
//     public int majorityElement(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int size = nums.length;
//         for(int a : nums){
//             map.put(a, map.getOrDefault(a, 0) + 1);
//         }

//         int max = 0;
//         int ans = -1;

//         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//             if(entry.getValue() > max){
//                 max = entry.getValue();
//                 ans = entry.getKey();
//             }
//             if(max > size / 2) return ans;
//         }
//         return ans;
//     }
// }

// class Solution {
//     public int majorityElement(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();

//         for(int a : nums){
//             map.put(a, map.getOrDefault(a, 0) + 1);
//         }

//         int max = 0;
//         int ans = -1;

//         for(Map.Entry<Integer, Integer> entry : map.entrySet()){
//             if(entry.getValue() > max){
//                 max = entry.getValue();
//                 ans = entry.getKey();
//             }
//         }
//         return ans;
//     }
// }