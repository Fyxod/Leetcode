class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int tot = 0;
        for(int a : nums){
            tot ^= a;
        }
        if(tot != 0) return n;
        boolean none = false;
        for(int a : nums){
            if(a != 0) none = true;
        }
        return none? n - 1 : 0;
    }
}
