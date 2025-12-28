class Solution {
    public int numDistinct(String s, String t) {
        int p = s.length();
        int q = t.length();
        if(q > p) return 0;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        int dp[][] = new int[p + 1][q + 1];

        for(int i = 1; i <= p; i++){
            for(int j = 1; j <= q; j++){
                if(arr1[i - 1] == arr2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                // System.out.print(dp[i][j]);
            }
            // System.out.println();
        }
        
        if(dp[p][q] != q) return 0;
        int l = dp[p][q];
        int mem[][] = new int[p + 1][q + 1];
        for(int a2[] : mem) Arrays.fill(a2, -1);
        return count(dp, dp[p][q], arr1, arr2, p, q, mem);
    }
    int count(int dp[][], int l, char arr1[], char arr2[], int i, int j, int mem[][]){
        if(i < 1 || j < 1){
            if(l == 0) return 1;
            return 0;
        }
        if(mem[i][j] != -1) return mem[i][j];
        int c = 0;
        if(arr1[i - 1] == arr2[j - 1]) c += count(dp, l - 1, arr1, arr2, i - 1, j - 1, mem);
        if(dp[i - 1][j] == dp[i][j]) c += count(dp, l, arr1, arr2, i - 1, j, mem);
        if(dp[i][j - 1] == dp[i][j]) c += count(dp, l, arr1, arr2, i, j - 1, mem);

        return mem[i][j] = c;
    }
}