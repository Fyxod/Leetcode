class Solution {
    int map[] = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
    String str;
    int len;
    int dp[][][];
    public int rotatedDigits(int n) {
        str = String.valueOf(n);
        len = str.length();
        
        dp = new int[len][2][n + 1];
        for(int arr[][] : dp) for(int arr2[] : arr) Arrays.fill(arr2, -1);

        return f(0, 1, 0);
    }
    int f(int idx, int tight, int num){
        if(idx == len) return check(num) ? 0 : 1;
        if(dp[idx][tight][num] != -1) return dp[idx][tight][num];

        int limit = tight == 1 ? str.charAt(idx) - '0' : 9;

        int res = 0;
        for(int i = 0; i <= limit; i++){
            if(map[i] == -1) continue;
            int t = (tight == 1 && i == limit) ? 1 : 0;
            res += f(idx + 1, t, num * 10 + i);
        }

        return dp[idx][tight][num] = res;
    }
    boolean check(int num){
        int rev = 0;
        String temp = String.valueOf(num);
        for(int i = 0; i < temp.length(); i++){
            rev = rev * 10 + map[temp.charAt(i) - '0'];
        }
        return rev == num;
    }
}