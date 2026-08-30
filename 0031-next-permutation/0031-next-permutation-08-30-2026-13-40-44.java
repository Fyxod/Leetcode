class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        int n = nums.length;
        int ind = n - 2;
        while(ind >= 0 && nums[ind] >= nums[ind + 1]) ind--;
        if(ind == -1){
            reverse(nums, 0, n - 1);
            return;
        }   
        int ind2 = n - 1;
        while(ind2 > ind && nums[ind2] <= nums[ind]) ind2--;
        int temp = nums[ind2];
        nums[ind2] = nums[ind];
        nums[ind] = temp;
        reverse(nums, ind + 1, n - 1);
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