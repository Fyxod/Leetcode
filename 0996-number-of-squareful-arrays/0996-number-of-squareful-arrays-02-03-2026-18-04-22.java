class Solution {
    int n;
    int dp[][][];
    Set<Integer>[] set;
    public int numSquarefulPerms(int[] nums) {
        n = nums.length;
        dp = new int[1 << n][n][n + 1];
        for(int a[][] : dp) for(int arr[] : a) Arrays.fill(arr, -1);
        set = new HashSet[n];
        for(int i = 0; i < n; i++) set[i] = new HashSet<>();
        return f(nums, 0, 0, n);
    }
    int f(int nums[], int mask, int idx, int last){
        if(idx == n) return 1;

        if(dp[mask][idx][last] != -1) return dp[mask][idx][last];
        int cnt = 0;

        for(int i = 0; i < n; i++){
            if((mask & (1 << i)) != 0 || !set[idx].add(nums[i])) continue;
            if(mask == 0){
                cnt += f(nums, mask | (1 << i), idx + 1, i);
            }
            else{
                int num = nums[i] + nums[last];
                int sq = (int)Math.sqrt(num);
                if(sq * sq == num || (sq + 1) * (sq + 1) == num) cnt += f(nums, mask | (1 << i), idx + 1, i);
            }
        }
        set[idx].clear();

        return dp[mask][idx][last] = cnt;
    }
}