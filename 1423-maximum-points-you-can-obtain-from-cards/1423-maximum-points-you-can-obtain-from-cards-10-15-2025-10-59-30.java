class Solution {
    int max = 0;
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int l = n - k;
        int r = n - 1;
        int sum = 0;
        for(int i = l; i <= r; i++){
            sum += nums[i];
        }
        int max = sum;
        for(int i = 0; i < k; i++){
            r = (r + 1) % n;
            sum += nums[r] - nums[l];
            l = (l + 1) % n;
            max = Math.max(max, sum);
        }
        return max;
    }
}