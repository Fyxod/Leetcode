class Solution {
    public void moveZeroes(int[] nums) {
        int write = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[write++] = nums[i];
            }
        }

        for(int i = write; i < n; i++) nums[i] = 0;
    }
}