class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(nums[i] != 0){
                if(nums[i] != nums[slow]){
                    int temp = nums[slow];
                    nums[slow] = nums[i];
                    nums[i] = temp;
                }
                slow++;
            }
        }
    }
}