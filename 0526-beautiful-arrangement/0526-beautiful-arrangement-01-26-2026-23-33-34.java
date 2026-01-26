class Solution {
    int dp[];
    public int countArrangement(int n) {
        int fullMask = (1 << n) - 1;
        dp = new int[fullMask + 1];
        dp[fullMask] = 1;
        for(int mask = fullMask - 1; mask >= 0; mask--){
            int pos = Integer.bitCount(mask) + 1;
            int res = 0;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0) continue;
                int num = i + 1;
                if(pos % num != 0 && num % pos != 0) continue;
                res += dp[mask | (1 << i)];
            }

            dp[mask] = res;

        }
        return dp[0];
    }
}