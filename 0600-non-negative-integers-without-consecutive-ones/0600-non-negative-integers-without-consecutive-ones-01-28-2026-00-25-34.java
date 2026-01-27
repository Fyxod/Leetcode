class Solution {
    String str;
    int len;
    int dp[][][];
    public int findIntegers(int n) {
        str = Integer.toBinaryString(n);
        len = str.length();

        dp = new int[len][2][2];
        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);

        return f(0, 1, 0);
    }
    int f(int idx, int tight, int last){
        if(idx == len) return 1;

        if(dp[idx][tight][last] != -1) return dp[idx][tight][last];

        int limit = tight == 1 ? str.charAt(idx) - '0' : 1;

        int res = 0;
        for(int i = 0; i <= limit; i++){
            if(last == 1 && i == 1) continue;
            int t = (tight == 1 && i == limit) ? 1 : 0;
            res += f(idx + 1, t, i);
        }

        return dp[idx][tight][last] = res;
    }
}