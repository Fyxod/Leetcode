class Solution {
    record Pair(int i, int sum){};
    static int INF = Integer.MAX_VALUE/2;
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int sum = 0;
        for(int a : nums) sum += a;
        Map<Pair, Integer> dp = new HashMap<>();
        return f(nums, dp, t, 0, 0);
    }
    int f(int nums[], Map<Pair, Integer> dp, int t, int i, int sum){
        if(i == nums.length){
            if(t == sum) return 1;
            else return 0;
        }
        Pair lookup = new Pair(i, sum);
        if(dp.containsKey(lookup)) return dp.get(lookup);
        int res = f(nums, dp, t, i + 1, sum + nums[i]) + f(nums, dp, t, i + 1, sum - nums[i]);
        dp.put(lookup, res);
        return res;
    }
}