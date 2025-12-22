class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(n, dp);
    }
    int helper(int n, int dp[]){
        if(n == 0) return 1;
        else if(n < 0) return 0;
        int first; 
        int sec;
        if(dp[n - 1] != -1) first = dp[n - 1];
        else{
            first = helper(n - 1, dp);
            dp[n - 1] = first;
        }
        if(n - 2 >= 0 && dp[n - 2] != -1) sec = dp[n - 2];
        else{
            sec = helper(n - 2, dp);
            if(n - 2 >= 0) dp[n - 2] = sec;
        }
        return first + sec;
    }
}