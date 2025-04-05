class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        int sum = 0;
        int max = nums[0];

        for(int a : nums){
            sum += a;
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }
        return max;
    }
}

// Divide and conquer - O(nlogn), O(logn)
// class Solution {
//     public int maxSubArray(int[] nums) {
//         return helper(nums, (nums.length - 1) /2 , 0, nums.length - 1);
//     }

//     int helper(int[] nums, int pivot, int start, int end){

//         if(start == end){
//             return nums[pivot];
//         }
//         int midSum = 0;

//         int temp = nums[pivot];
//         int leftMax = nums[pivot];
//         int leftIndex = pivot - 1;
//         while(leftIndex >= start){
//             temp += nums[leftIndex];
//             leftMax = Math.max(leftMax, temp);
//             leftIndex--;
//         }

//         temp = 0;
//         int rightMax = 0;
//         int rightIndex = pivot + 1;
//         while(rightIndex <= end){
//             temp += nums[rightIndex];
//             rightMax = Math.max(rightMax, temp);
//             rightIndex++;
//         }
//         midSum += leftMax + rightMax;

//         return Math.max(Math.max(helper(nums, (start + pivot) / 2, start, pivot), helper(nums, (pivot + 1 + end) / 2, pivot + 1, end)), midSum);
//     }
// }