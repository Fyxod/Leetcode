    class Solution {
        int target;
        String str;
        int len;
        int dp[][][];
        int fullMask;
        public int countNumbersWithUniqueDigits(int n) {
            target = (int)Math.pow(10, n) - 1;
            str = String.valueOf(target);
            len = str.length();
            fullMask = (1 << 10) - 1;
            dp = new int[len + 1][2][fullMask + 1];
            for(int i = 0; i <= fullMask; i++){
                dp[len][0][i] = 1;
                dp[len][1][i] = 1;
            }

            for(int idx = len - 1; idx >= 0; idx--){
                for(int tight = 0; tight < 2; tight++){
                    for(int mask = 0; mask <= fullMask; mask++){
                        int limit = tight == 1 ? str.charAt(idx) - '0' : 9;
    
                        int ans = 0;
                        for(int i = 0; i <= limit; i++){
                            if((mask & (1 << i)) != 0) continue;
                            int t = (tight == 1 && i == limit) ? 1 : 0;
                            int nm = mask;
                            if(i != 0 || mask != 0) nm = (nm | (1 << i));
                            ans += dp[idx + 1][t][nm];
                        }

                        dp[idx][tight][mask] = ans;
                    }
                }
            }
            return dp[0][1][0];
        }
    }