class Solution {
    int n;
    int dp[];
    public int maxSumAfterPartitioning(int[] arr, int lim) {
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return f(arr, lim,  0);
    }
    int f(int arr[], int lim, int i){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];

        int max = 0;
        int res = 0;
        for(int k = i; k < i + lim && k < n; k++){
            max = Math.max(max, arr[k]);
            res = Math.max(res, max * (k - i + 1) + f(arr, lim, k + 1));
        }

        return dp[i] = res;
    }
}