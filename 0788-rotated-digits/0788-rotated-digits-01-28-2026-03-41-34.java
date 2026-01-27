class Solution {
    int map[] = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
    String str;
    int len;
    int dp[][][];
    public int rotatedDigits(int n) {
        str = String.valueOf(n);
        len = str.length();
        
        dp = new int[len + 1][2][2];
        for(int idx = len; idx >= 0; idx--){
            for(int tight = 0; tight < 2; tight++){
                for(int changed = 0; changed < 2; changed++){
                    if(idx == len){
                        dp[idx][tight][changed] = changed;
                        continue;
                    }

                    int limit = tight == 1 ? str.charAt(idx) - '0' : 9;

                    int res = 0;
                    for(int i = 0; i <= limit; i++){
                        if(map[i] == -1) continue;
                        int ch = (changed == 1 || map[i] != i) ? 1 : 0;
                        int t = (tight == 1 && i == limit) ? 1 : 0;
                        res += dp[idx + 1][t][ch];
                    }

                    dp[idx][tight][changed] = res;
                }
            }
        }

        return dp[0][1][0];
    }
}