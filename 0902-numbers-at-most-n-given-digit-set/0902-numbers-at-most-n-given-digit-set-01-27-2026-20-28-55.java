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

        dp = new int[len][2][2];
        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);

        return f(0, 1, 0);
    }
    int f(int idx, int tight, int started){
        if(idx == len) return started;

        if(dp[idx][tight][started] != -1) return dp[idx][tight][started];
        int limit = tight == 1 ? str.charAt(idx) - '0' : 9;
        
        int res = 0;
        for(int i = started; i <= m; i++){
            int a = arr[i];
            if(a > limit) break;
            int t = (tight == 1 && a == limit) ? 1 : 0;
            res += f(idx + 1, t, a != 0 ? 1 : 0);
        }

        return dp[idx][tight][started] = res;
    }
}