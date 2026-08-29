class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int ans = Integer.MIN_VALUE;
        for(int a : nums){
            if(cnt == 0) ans = a;
            if(ans == a) cnt++;
            else cnt--;
        }

        return ans;
    }
}