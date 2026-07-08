class Solution {
    int n;
    int nums[];
    int sum, target;
    int k;
    int dp[];
    int fullMask;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.k = k;
        this.nums = nums;
        n = nums.length;
        sum = 0;
        for(int a : nums) sum += a;
        if(sum % k != 0) return false;
        target = sum / k;
        fullMask = (1 << n) - 1;
        dp = new int[fullMask + 1];

        return f(0, 0);
    }
    boolean f(int mask, int sum){
        if(sum == target){
            if(mask == fullMask) return true;
            sum = 0;
        }

        if(dp[mask] != 0) return dp[mask] == 1;
        boolean res = false;
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0) continue;
            if(sum + nums[i] <= target) res = res || f((mask | (1 << i)), sum + nums[i]);
        }
        dp[mask] = res ? 1 : -1;
        return res;
    }
}