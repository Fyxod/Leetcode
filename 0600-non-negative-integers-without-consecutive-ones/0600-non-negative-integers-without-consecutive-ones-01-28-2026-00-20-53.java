class Solution {
    String str;
    int len;
    int dp[][][][];
    public int findIntegers(int n) {
        str = Integer.toBinaryString(n);
        len = str.length();

        dp = new int[len][2][2][2];
        for(int a[][][] : dp)  for(int arr[][] : a) for(int arr2[] : arr) Arrays.fill(arr2, -1);

        return f(0, 1, 0, 0) + 1;
    }
    int f(int idx, int tight, int last, int started){
        if(idx == len) return started;

        if(dp[idx][tight][last][started] != -1) return dp[idx][tight][last][started];

        int limit = tight == 1 ? str.charAt(idx) - '0' : 1;

        int res = 0;
        for(int i = 0; i <= limit; i++){
            if(last == 1 && i == 1) continue;
            int s = (started == 1 || i == 1) ? 1 : 0;
            int t = (tight == 1 && i == limit) ? 1 : 0;
            res += f(idx + 1, t, i, s);
        }

        return dp[idx][tight][last][started] = res;
    }
}