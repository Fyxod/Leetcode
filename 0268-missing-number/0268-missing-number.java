class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        for(int i = 0; i < n; i++){
            sum -= nums[i];
        }
        return sum;
    }
}

// brute force
// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int arr[] = new int[n + 1];

//         for(int a: nums){
//             arr[a]++;
//         }
        
//         for(int i = 0; i < n + 1; i++){
//             if(arr[i] == 0) return i;
//         }
//         return -1;
//     }
// }