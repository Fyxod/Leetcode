class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int size = nums.length;
        int i = size - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        if(i < 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int next = getNextLargestElementIndex(nums, i);

        int temp = nums[next];
        nums[next] = nums[i];
        nums[i] = temp;

        reverse(nums, i + 1, size - 1);
    }

    int getNextLargestElementIndex(int nums[], int i){
        int target = nums[i];
        int left = i + 1;
        int right = nums.length - 1;
        int ans = -1;

        while(left <= right){
            int mid = (right - left)/2 + left;
            if(target >= nums[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
























// class Solution {
//     public void nextPermutation(int[] nums) {
//         int i = 2;
//         int size = nums.length;
//         int max = nums[size - 1];
//         int curr = nums[size - 1];
//         int maxIndex = size - 1;
//         while(i <= size){
//             int n = nums[size - i];
//             if(n > max){
//                 max = n;
//                 maxIndex = size - i;
//             }
//             curr = curr + (int)Math.pow(n, Integer.toString(curr).length());
//             if(max != n){
//                 int tempMax = max;
//                 int tempMaxIndex = maxIndex;
//                 for(int k = size - i; k < size; k++){
//                     if(nums[k] > n && nums[k] < tempMax){
//                         tempMax = nums[k];
//                         tempMaxIndex = k;
//                     }
//                 }
//                 nums[size - i] = tempMax;
//                 nums[tempMaxIndex] = n;
//                 Arrays.sort(nums, size - i + 1, size);
//                 return;
//             }
//             else i++;
//         }
//         Arrays.sort(nums);
//         return;
//     }
// }