class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lowerbound = -1;
        int upperbound = nums.length;

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] >= target){
                lowerbound = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        lowerbound = (lowerbound >= 0 && nums[lowerbound] == target)? lowerbound : -1;

        low = 0;
        high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > target){
                upperbound = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        upperbound = (upperbound > 0 && nums[upperbound - 1] == target)? upperbound - 1 : -1;

        return new int[]{lowerbound, upperbound};
    }
}