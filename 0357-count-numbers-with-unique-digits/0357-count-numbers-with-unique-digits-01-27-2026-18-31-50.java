class Solution {
    int len, fullMask;
    String str;
    int dp[][][];
    public int countNumbersWithUniqueDigits(int n) {
        int num = (int)Math.pow(10, n) - 1;
        str = String.valueOf(num);  
        len = str.length();
        dp = new int[len][2][1 << 10];
        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);

        return f(0, 1, 0) + 1;
    }
    int f(int idx, int tight, int mask){
        if(idx == len) return mask == 0 ? 0 : 1;

        if(dp[idx][tight][mask] != -1) return dp[idx][tight][mask];
        int limit = tight == 1 ? str.charAt(idx) - '0' : 9;
        
        int res = 0;
        for(int i = 0; i <= limit; i++){
            if((mask & (1 << i)) != 0) continue;
            int t = (tight == 1 && i == limit) ? 1 : 0;
            int nmask = mask;
            if(i != 0 || mask != 0) nmask = nmask | (1 << i);
            res += f(idx + 1, t, nmask);
        }

        return dp[idx][tight][mask] = res;
    }
}