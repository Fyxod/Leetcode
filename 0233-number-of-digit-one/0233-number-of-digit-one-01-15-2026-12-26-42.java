class Solution {
    public int countDigitOne(int n) {
        int dp[][][] = new int[10][2][10];
        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);
        String s = String.valueOf(n);
        return f(dp, s, 0, 1, 0);
    }
    int f(int dp[][][], String s, int idx, int tight, int cnt){
        if(idx == s.length()) return cnt;
        if(dp[idx][tight][cnt] != -1) return dp[idx][tight][cnt];

        int limit = tight == 1 ? s.charAt(idx) - '0' : 9;

        int ans = 0;
        for(int i = 0; i <= limit; i++){
            int updateCnt = cnt + (i == 1 ? 1 : 0);
            int t = (tight == 1 && i == s.charAt(idx) - '0') ? 1 : 0;
            ans += f(dp, s, idx + 1, t, updateCnt);
        }

        return dp[idx][tight][cnt] = ans;
    }
}