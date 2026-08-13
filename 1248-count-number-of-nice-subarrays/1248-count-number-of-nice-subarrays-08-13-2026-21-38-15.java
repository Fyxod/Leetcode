class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return lse(nums, k) - lse(nums, k - 1);
    }
    int lse(int nums[], int k){
        int n = nums.length;
        int cnt = 0;
        int ans = 0;

        int l = 0;
        for(int r = 0; r < n; r++){
            if(nums[r] % 2 != 0) cnt++;
            while(cnt > k){
                if(nums[l++] % 2 != 0) cnt--;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}