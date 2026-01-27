class Solution {
    String str;
    int len;
    int dp[][][][];
    public int numDupDigitsAtMostN(int n) {
        str = String.valueOf(n);
        len = str.length();
        int fullMask = 1 << 10;
        dp = new int[len + 1][2][fullMask][2];
        for(int idx = len; idx >= 0; idx--){
            for(int tight = 0; tight < 2; tight++){
                for(int mask = 0; mask < fullMask; mask++){
                    for(int repeat = 0; repeat < 2; repeat++){
                        if(idx == len){
                            dp[idx][tight][mask][repeat] = repeat;
                            continue;
                        }

                        int limit = tight == 1 ? str.charAt(idx) - '0' : 9;
                        int res = 0;
                        for(int i = 0; i <= limit; i++){
                            int t = tight == 1 && i == limit ? 1 : 0;
                            int r = repeat;
                            if(r == 0 && (mask & (1 << i)) != 0) r = 1;
                            int nmask = mask;
                            if(mask != 0 || i != 0) nmask = nmask | (1 << i);
                            res +=  dp[idx + 1][t][nmask][r];
                        }

                        dp[idx][tight][mask][repeat] = res;
                    }
                }
            }
        }
        
        return dp[0][1][0][0];
    }
}