class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count1 = lte(nums, k);
        int count2 = lte(nums, k - 1);
        return count1 - count2;
    }
    int lte(int nums[], int k){
        int count = 0;
        int odds = 0;
        int l = 0, r = 0;
        while(r < nums.length){
            if(nums[r] % 2 != 0) odds++;
            while(odds > k){
                if(nums[l] % 2 != 0) odds--;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}