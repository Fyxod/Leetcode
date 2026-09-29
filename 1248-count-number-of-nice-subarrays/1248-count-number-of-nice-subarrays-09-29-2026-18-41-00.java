class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }
    int f(int nums[], int k){
        if(k < 0) return 0;
        int left = 0;
        int cnt = 0;
        int ans = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] % 2 != 0) cnt++;
            while(cnt > k){
                if(nums[left] % 2 != 0) cnt--;
                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}