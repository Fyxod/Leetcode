class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return f(dp, arr, k, 0);
    }
    int f(int dp[], int arr[], int k, int i){
        if(i == arr.length) return 0;

        if(dp[i] != -1) return dp[i];

        int maxSum = 0;
        int max = Integer.MIN_VALUE;
        for(int j = i; j < i + k && j < arr.length; j++){
            max = Math.max(max, arr[j]);
            maxSum = Math.max(maxSum, (j - i + 1) * max + f(dp, arr, k, j + 1));
        }

        return dp[i] = maxSum;
    }
}