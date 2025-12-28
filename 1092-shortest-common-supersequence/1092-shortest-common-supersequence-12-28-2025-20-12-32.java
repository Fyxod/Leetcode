class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int p = str1.length();
        int q = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int dp[][] = new int[p + 1][q + 1];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i = 1; i <= p; i++){
            for(int j = 1; j <= q; j++){
                if(arr1[i - 1] == arr2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        int l = dp[p][q];

        int i = p, j = q, len = 0;
        while(i > 0 && j > 0 && len < l){
            if(dp[i][j - 1] == dp[i][j]) j--;
            else if(dp[i - 1][j] == dp[i][j]) i--;
            else {
                set1.add(i - 1);
                set2.add(j - 1);
                len++;
                i--;
                j--;
            }
        }
        // System.out.println(len);
        // System.out.println(set1);
        // System.out.println(set2);
        StringBuilder sb = new StringBuilder();
        i = 0; j = 0;

        while(i < p || j < q){
            while(i < p && !set1.contains(i)){
                sb.append(arr1[i]);
                i++;
            }
            while(j < q && !set2.contains(j)){
                sb.append(arr2[j]);
                j++;
            }
            if(i < p && j < q){
                sb.append(arr1[i]);
                i++;
                j++;
            }
        }
        return sb.toString();
    }
}