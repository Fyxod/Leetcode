class Solution {
    public int longestOnes(int[] nums, int k) {
        int c = 0, l = 0, r = 0, max = 0;
        while(r < nums.length){
            if(nums[r] == 0) c++;
            if(c <= k){
                    max = Math.max(r - l + 1, max);
            }
            else{
                while(c > k) {
                    if(nums[l] == 0) c--;
                    l++;
                }
            }
            r++;
        }
        return max;
    }
}