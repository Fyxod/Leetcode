class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int ans = nums[0];
        for(int a : nums){
            if(ans == a){
                cnt++;
            }
            else{
                cnt--;
                if(cnt == 0){
                    ans = a;
                    cnt = 1;
                }
            }
        }

        return ans;
    }
}