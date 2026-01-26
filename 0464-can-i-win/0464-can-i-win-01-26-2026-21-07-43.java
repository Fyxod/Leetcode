class Solution {
    int fullMask;
    Boolean dp[];
    int n;
    public boolean canIWin(int max, int total) {
        if((max * (max + 1)) / 2 < total) return false;
        if(total == 0) return true;
        n = max;
        fullMask = (1 << max) - 1;
        dp = new Boolean[fullMask + 1];

        return f(0, total);
    }
    boolean f(int mask, int remaining){
        if(dp[mask] != null) return dp[mask];

        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0) continue;
            int pick = i + 1;

            if(pick >= remaining) return dp[mask] = true;

            if(!f(mask | (1 << i), remaining - pick)) return dp[mask] = true;
        }

        return dp[mask] = false;
    }
}