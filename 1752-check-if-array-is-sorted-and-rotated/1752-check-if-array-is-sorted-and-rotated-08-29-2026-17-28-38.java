class Solution {
    public boolean check(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]) cnt++;
            if(cnt == 2) return false;
        }
        if(cnt == 0) return true;
        else return nums[nums.length - 1] <= nums[0];
    }
}