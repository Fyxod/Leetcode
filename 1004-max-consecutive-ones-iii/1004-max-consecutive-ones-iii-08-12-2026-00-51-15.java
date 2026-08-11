class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int n = nums.length;

        int cnt = 0; // zero count
        int last = -1;
        int max = 0;
        while(r < n){
            if(nums[r] == 0) cnt++;
            while(cnt > k) if(nums[l++] == 0) cnt--;
            r++;
            max = Math.max(max, r - l);
        }

        return max;
    }
}