class Solution {
    int n1;
    int n2;
    public int minDistance(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();

        return n1 + n2 - 2 * f(word1, word2);
    }
    public int f(String text1, String text2) {
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