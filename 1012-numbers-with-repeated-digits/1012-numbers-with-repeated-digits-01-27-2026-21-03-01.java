class Solution {
    String str;
    int len;
    int dp[][][][];
    public int numDupDigitsAtMostN(int n) {
        str = String.valueOf(n);
        len = str.length();
        int fullMask = 1 << 10;
        dp = new int[len][2][fullMask][2];
        for(int arr[][][] : dp)
            for(int arr2[][] : arr)
                for(int arr3[] : arr2)
                    Arrays.fill(arr3, -1);
        
        return f(0, 1, 0, 0);
    }
    int f(int idx, int tight, int mask, int repeat){
        if(idx == len) return repeat;
        if(dp[idx][tight][mask][repeat] != -1) return dp[idx][tight][mask][repeat];

        int limit = tight == 1 ? str.charAt(idx) - '0' : 9;
        
        int res = 0;
        for(int i = 0; i <= limit; i++){
            int t = tight == 1 && i == limit ? 1 : 0;
            int r = repeat;
            if(r == 0 && (mask & (1 << i)) != 0) r = 1;
            int nmask = mask;
            if(mask != 0 || i != 0) nmask = nmask | (1 << i);
            res += f(idx + 1, t, nmask, r);
        }

        return dp[idx][tight][mask][repeat] = res;
    }
}