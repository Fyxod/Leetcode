class Solution {
    int n;
    int nums[];
    public int rob(int[] nums) {
        n = nums.length;
        this.nums = nums;
        int next = 0, secondNext = 0;

        for(int i = n - 1; i >= 0; i--){
            int curr = Math.max(next, nums[i] + secondNext);
            secondNext = next;
            next = curr;
        }

        return next;
    }
}