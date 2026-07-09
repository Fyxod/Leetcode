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
            for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);

            return f(0, 1, 0);
        }
        
        int f(int idx, int tight, int mask){
            if(idx == len) return 1;
            if(dp[idx][tight][mask] != -1) return dp[idx][tight][mask];

            int limit = tight == 1 ? str.charAt(idx) - '0' : 9;
    
            int ans = 0;
            for(int i = 0; i <= limit; i++){
                if((mask & (1 << i)) != 0) continue;
                int t = (tight == 1 && i == limit) ? 1 : 0;
                int nm = mask;
                if(i != 0 || mask != 0) nm = (nm | (1 << i));
                ans += f(idx + 1, t, nm);
            }

            return dp[idx][tight][mask] = ans;
        }
    }