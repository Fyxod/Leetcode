class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int dp[][] = new int[n1 + 1][n2 + 1];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return  f(dp, word1, word2, n1 - 1, n2 - 1);
    }
    int f(int dp[][], String word1, String word2, int i, int j){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;

        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = f(dp, word1, word2, i - 1, j - 1);
        else{
            int p1 = f(dp, word1, word2, i - 1, j);
            int p2 = f(dp, word1, word2, i, j - 1);
            int p3 = f(dp, word1, word2, i - 1, j - 1);

            return dp[i][j] = 1 + Math.min(p1, Math.min(p2, p3));
        }
    }
}