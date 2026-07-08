class Solution {
    int dp[];
    int n;
    int fullMask;
    public int countArrangement(int n) {
        this.n = n;
        fullMask = 1 << n;
        dp = new int[fullMask];
        Arrays.fill(dp, -1);

        return f(0);
    }
    int f(int mask){
        int pos = Integer.bitCount(mask);
        if(pos == n) return 1;

        if(dp[mask] != -1) return dp[mask];

        int res = 0;
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0) continue;
            if((pos + 1) % (i + 1) == 0 || (i + 1) % (pos + 1) == 0) res += f(mask | (1 << i));
        }
        return dp[mask] = res;
    }
}