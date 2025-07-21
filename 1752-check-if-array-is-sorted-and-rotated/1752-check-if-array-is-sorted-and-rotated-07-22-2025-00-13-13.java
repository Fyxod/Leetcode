class Solution {
    public boolean check(int[] nums) {
        boolean flag = false;

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                if(flag || nums[i] < nums[nums.length - 1] || nums[nums.length - 1] > nums[0]) return false;

                flag = true;
            }
        }
        return true;
    }
}