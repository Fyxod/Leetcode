class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int par[] = new int[n];
        Arrays.sort(nums);

        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) par[i] = i;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    par[i] = j;
                }
            }
        }

        int maxI = 0;
        for(int i = 0; i < n; i++){
            if(dp[maxI] < dp[i]) maxI = i;
        }
        int i = maxI;
        List<Integer> list = new ArrayList<>();
        while(i != par[i]) {
            list.add(nums[i]);
            i = par[i];
        }
        list.add(nums[i]);
        Collections.reverse(list);
        return list;
    }
}