class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n + 1];
        int curr[] = new int[n + 1];

        for(int i = n - 1; i >= 0; i--){
            for(int last = i; last >= 0; last--){
                int val = last == 0 ? Integer.MIN_VALUE : nums[last - 1];

                int l;
                if(nums[i] > val) l = Math.max(
                    1 + dp[i + 1],
                    dp[last]
                );
                else l = dp[last];
                curr[last] = l;
            }
            dp = curr;
        }
        

        return dp[0];
    }
}