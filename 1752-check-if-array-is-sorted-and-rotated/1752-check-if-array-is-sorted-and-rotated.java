class Solution {
    public boolean check(int[] nums) {
        if(nums.length == 1) return true;
        int change = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]) {
                change+=1;
                if(change > 1) return false;
            }
        }
        if(change > 0 && nums[nums.length - 1] > nums[0]){
            return false;
        }
        return true;
    }
}
