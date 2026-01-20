class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();

        return f(s, t);
    }
    public int f(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int dp[] = new int[n2 + 1];
        int curr[] = new int[n2 + 1];
        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    curr[j] = 1 + dp[j + 1];
                }
                else curr[j] = Math.max(dp[j], curr[j + 1]);
            }
            int temp[] = dp;
            dp = curr;
            curr = temp;
        }

        return dp[0];
    }
}