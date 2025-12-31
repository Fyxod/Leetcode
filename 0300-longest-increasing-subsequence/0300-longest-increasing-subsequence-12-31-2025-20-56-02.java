class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int last = 0; last <= n; last++){
                int val = last == 0 ? Integer.MIN_VALUE : nums[last - 1];

                int l;
                if(nums[i] > val) l = Math.max(
                    1 + dp[i + 1][i + 1],
                    dp[i + 1][last]
                );
                else l = dp[i + 1][last];
                dp[i][last] = l;
            }
        }
        

        return dp[0][0];
    }
}