class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        
        boolean pal[][] = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)) pal[i][j] = j - i < 2 || pal[i + 1][j - 1];
            }
        }

        for(int start = n - 1; start >= 0; start--){
            int min = Integer.MAX_VALUE;
            for(int end = start; end < s.length(); end++){
                if(pal[start][end]){
                    min = Math.min(min, dp[end + 1]);
                }
            }

            dp[start] = 1 + min;
        }
        return dp[0] - 1;
    }
    boolean isPal(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}