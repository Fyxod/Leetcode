class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < 32; i++){
            int zeroes = 0;
            int count = 0;
            for(int j = 0; j < n; j++){
                if(((1 << i) & nums[j]) != 0) count++;

                if(nums[j] == 0) zeroes++;
            }
            if(zeroes == n) return 0;
            if(count % 2 == 1) return n;
        }
        return n - 1;
    }
}
