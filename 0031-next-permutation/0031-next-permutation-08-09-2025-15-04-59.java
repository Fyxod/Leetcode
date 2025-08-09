class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for(int i = n - 2; i >=0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        System.out.println(index);
        if(index == -1){
            reverse(nums, 0, n - 1);
            return;
        }
        int swapI = index + 1;
        for(int i = index + 2; i < n; i++){
            if(nums[i] > nums[index] && nums[i] <= nums[swapI]){
                swapI = i;
            }
        }
        int temp = nums[swapI];
        nums[swapI] = nums[index];
        nums[index] = temp;
        reverse(nums, index + 1, n - 1);
    }
    void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++; end--;
        }
    }
}