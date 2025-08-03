class Solution {
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int min = i;
            if(nums[min]*2 > target) break;
            int max = i;
            int low = i + 1;
            int high = nums.length - 1;
            if(low != nums.length){
                while(low <= high){
                    int mid = low + (high - low) / 2;
                    if(nums[mid] + nums[min] <= target){
                        low = mid + 1;
                    }
                    else{
                        high = mid - 1;
                    }
                }
                max = high;
            }
            int n = max - min;
            ans = (ans + myPow(2, n)) % mod;
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
// class Solution {
//     public int numSubseq(int[] nums, int target) {
//         return helper(nums, target, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
//     }
//     int helper(int nums[], int target, int max, int min, int  index, int count){
//         if(index == nums.length) return count;
//         int tempMax = Math.max(max, nums[index]);
//         int tempMin = Math.min(min, nums[index]);
//         boolean valid = false;
//         if(tempMax + tempMin <= target) valid = true;
//         return helper(nums, target, tempMax, tempMin, index + 1, valid? count + 1 : count) + 
//         helper(nums, target, max, min, index + 1, count);
//     }
// }