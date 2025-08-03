class Solution {
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] + nums[right] <= target){
                ans = (ans + myPow(2, right - left)) % mod;
                left++;
            }
            else right--;
        }
        return ans;
    }

    int myPow(int base, int n){
        long result = 1;
        long b = base;
        if(n == 0) return 1;
        while(n > 0){
            if(n % 2 != 0){
                result = (result * b) % mod;
            }
            n /= 2;
            b = (b * b) % mod;
        }
        return (int)result;
    }
}