class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int dp[][] = new int[n][m];
        for(int arr[] : dp) Arrays.fill(arr, -1);

        return f(dp, nums1, nums2, 0, 0);
    }
    int f(int dp[][], int nums1[], int nums2[], int i, int j){
        if(i == nums1.length || j == nums2.length) return Integer.MIN_VALUE / 2;
        
        if(dp[i][j] != -1) return dp[i][j];
        int pro = nums1[i] * nums2[j];
        int max = pro;
        max = Math.max(max, pro + f(dp, nums1, nums2, i + 1, j + 1));
        max = Math.max(max, f(dp, nums1, nums2, i + 1, j + 1));
        max = Math.max(max, f(dp, nums1, nums2, i + 1, j));
        max = Math.max(max, f(dp, nums1, nums2, i, j + 1));

        return dp[i][j] = max;
    }
}