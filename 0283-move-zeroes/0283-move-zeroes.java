class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) return;
        int slow = 0;
        int fast = 0;
        while(slow < nums.length && nums[slow] != 0) slow++;
        fast = slow + 1;
        while(fast < nums.length){
            if (nums[fast] != 0){
                nums[slow] = nums[fast];
                nums[fast] = 0;
                slow++;
            }
            fast++;
        }
    }
}