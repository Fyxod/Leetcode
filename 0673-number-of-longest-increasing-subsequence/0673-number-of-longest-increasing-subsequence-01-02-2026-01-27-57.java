class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n][2];
        for(int a[] : dp){
            a[0] = 1;
            a[1] = 1;
        }

        int max = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j][0] + 1 > dp[i][0]){
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    }
                    else if(dp[j][0] + 1 == dp[i][0]){
                        dp[i][1] += dp[j][1];
                    }
                    max = Math.max(max, dp[i][0]);
                }
            }
        }
        int ans = 0;
        for(int arr[] : dp){
            if(arr[0] == max) ans += arr[1];
        }
        return ans;
    }
}