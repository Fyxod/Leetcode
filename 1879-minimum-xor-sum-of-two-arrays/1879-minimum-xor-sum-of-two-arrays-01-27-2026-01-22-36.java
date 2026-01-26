class Solution {
    int dp[];
    int n;
    int INF = Integer.MAX_VALUE / 2;
    public int minimumXORSum(int[] nums1, int[] nums2) {
        n = nums1.length;
        
        dp = new int[1 << n];
        Arrays.fill(dp, -1);

        return f(0, 0, nums1, nums2);
    }
    int f(int mask, int pos, int nums1[], int nums2[]){
        if(pos == n) return 0;

        if(dp[mask] != -1) return dp[mask];

        int min = INF;
        int x = nums1[pos];
        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0) continue;
            min = Math.min(min, (x ^ nums2[i]) + f(mask | (1 << i), pos + 1, nums1, nums2));
        }

        return dp[mask] = min;
    }
}