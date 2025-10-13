class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count1 = lte(nums, goal);
        int count2 = lte(nums, goal - 1);
        return count1 - count2;
    }

    int lte(int nums[], int goal){
        if(goal < 0) return 0;
        
        int count = 0;
        int l = 0, r = 0;
        int sum = 0;
        while(r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}