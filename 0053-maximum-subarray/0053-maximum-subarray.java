class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    int helper(int arr[], int start, int end){
        if(end == start) return arr[start];
        int pivot = (start + end) / 2;
        int leftSum = helper(arr, start, pivot);
        int rightSum = helper(arr, pivot + 1, end);

        int leftCrossSum = Integer.MIN_VALUE;
        int rightCrossSum = Integer.MIN_VALUE;
        int tempSum = 0;

        for(int i = pivot; i >= start; i--){
            tempSum += arr[i];
            leftCrossSum = Math.max(leftCrossSum, tempSum);
        }
        tempSum = 0;
        for(int i = pivot + 1; i <= end; i++){
            tempSum += arr[i];
            rightCrossSum = Math.max(rightCrossSum, tempSum);
        }
        int crossSum = leftCrossSum + rightCrossSum;

        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }
}





















// legacy code below - ignore






















// finding the subarray with the maximum sum
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int sum = 0;
//         int max = nums[0];
//         int startIndex = 0;
//         int endIndex = 0;
//         int tempStart = 0;

//         for(int i = 0; i < nums.length; i++){
//             sum += nums[i];
//             if(sum > max){
//                 max = sum;
//                 endIndex = i;
//                 startIndex = tempStart;
//             }
//             if(sum < 0){
//                 sum = 0;
//                 tempStart = i + 1;
//             }
//         }
//         System.out.println(startIndex + " " + endIndex);
//         return max;
//     }
// }

// following is kadane but more in a dp form
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int sum = 0;
//         int max = nums[0];

//         for(int a : nums){
//             sum = Math.max(a, sum + a);
//             max = Math.max(sum, max);
//         }
//         return max;
//     }
// }

// kadane
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int sum = 0;
//         int max = nums[0];

//         for(int a : nums){
//             sum += a;
//             max = Math.max(max, sum);
//             if(sum < 0) sum = 0;
//         }
//         return max;
//     }
// }

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