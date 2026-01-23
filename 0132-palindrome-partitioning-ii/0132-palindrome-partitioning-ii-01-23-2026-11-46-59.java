class Solution {
    int n;
    int dp[];
    public int minCut(String s) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        return f(s, 0);
    }
    int f(String s, int start){
        if(start == n) return -1;

        if(dp[start] != -1) return dp[start];

        int min = n + 1;
        for(int i = start; i < n; i++){
            if(isPal(s, start, i)){
                min = Math.min(min, f(s, i + 1));
            }
        }

        return dp[start] = 1 + min;
    }
    boolean isPal(String s, int i, int j){
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}