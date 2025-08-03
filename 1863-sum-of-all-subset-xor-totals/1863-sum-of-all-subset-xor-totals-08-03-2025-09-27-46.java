class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        if(nums.length == 0) return 0;
        helper(nums, 0, 0);
        return ans;
    }
    void helper(int nums[], int index, int curr){
        if(index == nums.length){
            ans += curr;
            return;
        }
        helper(nums, index + 1, curr ^ nums[index]);
        helper(nums, index + 1, curr);
    }
}