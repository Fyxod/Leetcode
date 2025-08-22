class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 31; i >= 0; i--){
            int cnt = 0;
            for(int j = 0; j < nums.length; j++){
                if(((1 << i) & nums[j]) != 0) cnt++;
            }
            ans = ans << 1;
            if(cnt % 2 != 0) ans += 1;
        }
        return ans;
    }
}