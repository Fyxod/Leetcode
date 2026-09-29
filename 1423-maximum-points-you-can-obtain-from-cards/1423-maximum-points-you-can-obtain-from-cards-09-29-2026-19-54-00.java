class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for(int i = 0; i < k; i++) sum += nums[i];
        int max = sum;
        for(int i = 0; i < k; i++){
            sum += nums[n - i - 1] - nums[k - i - 1];
            max = Math.max(max, sum);
        }

        return max;
    }
}