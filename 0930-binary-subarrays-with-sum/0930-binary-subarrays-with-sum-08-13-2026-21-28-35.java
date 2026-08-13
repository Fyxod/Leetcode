class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums, goal) - f(nums, goal - 1);
    }
    int f(int nums[], int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int sum = 0;
        int l = 0;
        int ans = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l++];
            }
            ans += r - l + 1;
        }

        return ans;
    }
}