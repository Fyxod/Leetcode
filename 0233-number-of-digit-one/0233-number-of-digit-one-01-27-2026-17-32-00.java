class Solution {
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int dp[][][] = new int[len + 1][2][len + 1];
        
        for(int t = 0; t <= 1; t++){
            for(int cnt = 0; cnt <= len; cnt++){
                dp[len][t][cnt] = cnt;
            }
        }

        for(int idx = len - 1; idx >= 0; idx--){
            for(int tight = 0; tight <= 1; tight++){
                int limit = tight == 1 ? s.charAt(idx) - '0' : 9;

                for(int cnt = 0; cnt <= len; cnt++){
                    int ans = 0;

                    for(int i = 0; i <= limit; i++){
                        int upCnt = cnt + (i == 1 ? 1 : 0);
                        if(upCnt > len) continue;
                        int t = (tight == 1 && i == s.charAt(idx) - '0') ? 1 : 0;
                        ans += dp[idx + 1][t][upCnt];
                    }
                    dp[idx][tight][cnt] = ans;
                }
            }
        }

        return dp[0][1][0];
    }
}