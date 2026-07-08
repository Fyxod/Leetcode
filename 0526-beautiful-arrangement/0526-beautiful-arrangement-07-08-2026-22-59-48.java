class Solution {
    int dp[];
    int n;
    int fullMask;
    public int countArrangement(int n) {
        this.n = n;
        fullMask = 1 << n;
        dp = new int[fullMask];
        dp[fullMask - 1] = 1;
        for(int mask = fullMask - 2; mask >= 0; mask--){
            int pos = Integer.bitCount(mask);
            int res = 0;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0) continue;
                if((pos + 1) % (i + 1) == 0 || (i + 1) % (pos + 1) == 0) res += dp[(mask | (1 << i))];
            }
            dp[mask] = res;
        }

        return dp[0];
    }
}