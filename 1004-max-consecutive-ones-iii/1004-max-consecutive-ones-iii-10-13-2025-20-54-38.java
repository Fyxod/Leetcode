class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int max = 0;
        int l = 0, r = 0;

        while(r < nums.length){
            if(nums[r] == 0) count++;
            if(count > k){
                if(nums[l] == 0) count--;
                l++;
            }
            if(count <= k){
                max = Math.max(max, r - l + 1);
            }
            r++;
        }
        return max;
    }
}