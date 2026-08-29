class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) return 1;
        int curr = nums[0];
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]) continue;
            nums[j] = nums[i];
            j++;
        }
        return j;
    }
}