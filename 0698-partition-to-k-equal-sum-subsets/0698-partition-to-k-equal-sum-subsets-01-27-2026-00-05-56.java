class Solution {
    int fullMask;
    int n;
    int dp[];
    public boolean canPartitionKSubsets(int[] nums, int k) {
        n = nums.length;
        fullMask = (1 << n) - 1;
        int sum = 0;
        for(int a : nums) {
            sum += a;
        }
        if(sum % k != 0) return false;
        dp = new int[fullMask + 1];
        int tar = sum / k;
        return f(tar, k, 0, 0, nums);
    }
    boolean f(int sum, int k, int mask, int s, int nums[]){
        if(mask == fullMask) return sum == s && k == 1;
        if(dp[mask] != 0) return dp[mask] == 1;
        if(sum == s){
            s = 0;
            k--;
        }
        if(k <= 0) return false;

        boolean res = false;
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0) continue;
            if(s + nums[i] <= sum) {
                res = res || f(sum, k, mask | (1 << i), s + nums[i], nums);
                if(res) break;
            }
        }

        dp[mask] = res ? 1 : -1;
        return res;
    }
}