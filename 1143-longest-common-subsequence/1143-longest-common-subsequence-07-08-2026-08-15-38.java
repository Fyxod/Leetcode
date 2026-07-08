class Solution {
    int n1, n2;
    int dp[][];
    char[] s1, s2;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1.toCharArray();
        s2 = text2.toCharArray();
        n1 = text1.length();
        n2 = text2.length();

        dp = new int[n1 + 1][n2 + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(0, 0);
    }
    int f(int i, int j){
        if(i >= n1 || j >= n2) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1[i] == s2[j]) return dp[i][j] = 1 + f(i + 1, j + 1);
        return dp[i][j] = Math.max(f(i + 1, j), f(i, j + 1));
    }
}