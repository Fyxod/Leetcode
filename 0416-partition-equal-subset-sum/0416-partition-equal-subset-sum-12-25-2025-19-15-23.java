class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        return f(nums, 0, 0, 0, n);
    }
    boolean f(int nums[], int i, int sum1, int sum2, int n){
        if(i == n){
            if(sum1 == sum2) return true;
            else return false;
        }

        return f(nums, i + 1, sum1 + nums[i], sum2, n) || f(nums, i + 1, sum1, sum2 + nums[i], n);
    }
}