class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int cnt = 0;

        int l = 0;
        for(int r = 0; r < n; r++){
            if(nums[r] == 0) cnt++;
            while(l <= r && cnt > k) if(nums[l++] == 0) cnt--;
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}