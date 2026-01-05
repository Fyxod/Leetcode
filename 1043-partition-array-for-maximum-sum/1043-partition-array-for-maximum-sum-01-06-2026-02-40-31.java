class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + 1];
        
        for(int i = n - 1; i >= 0; i--){
            int maxSum = 0;
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k && j < arr.length; j++){
                max = Math.max(max, arr[j]);
                maxSum = Math.max(maxSum, (j - i + 1) * max + dp[j + 1]);
            }

            dp[i] = maxSum;
        }

        return dp[0];
    }
}