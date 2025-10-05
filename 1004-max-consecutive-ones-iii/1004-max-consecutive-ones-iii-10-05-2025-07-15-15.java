class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, startZero = -1, max = 0, count = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r] == 0){
                count++;
            }
            if(count > k){
                while(count > k){
                    if(nums[l] == 0){
                        count--;
                    }
                    l++;
                }
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}