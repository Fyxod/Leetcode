class Solution {
    int m, len;
    int arr[];
    int dp[][][];
    String str;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        str = String.valueOf(n);
        len = str.length();
        m = digits.length;
        arr = new int[m + 1];
        for(int i = 1; i <= m; i++){
            arr[i] = Integer.parseInt(digits[i - 1]);
        }

        dp = new int[len + 1][2][2];
        for(int idx = len; idx >= 0; idx--){
            for(int tight = 0; tight < 2; tight++){
                for(int started = 0; started < 2; started++){
                    if(idx == len){
                        dp[idx][tight][started] = started;
                        continue;
                    }
                    int limit = tight == 1 ? str.charAt(idx) - '0' : 9;
                    
                    int res = 0;
                    for(int i = started; i <= m; i++){
                        int a = arr[i];
                        if(a > limit) break;
                        int t = (tight == 1 && a == limit) ? 1 : 0;
                        res += dp[idx + 1][t][a != 0 ? 1 : 0];
                    }

                    dp[idx][tight][started] = res;
                }
            }
        }

        return dp[0][1][0];
    }
}