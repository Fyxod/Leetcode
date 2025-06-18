class Solution {
    public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int high = nums.length - 1;
        int low = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(target <= nums[mid]){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}