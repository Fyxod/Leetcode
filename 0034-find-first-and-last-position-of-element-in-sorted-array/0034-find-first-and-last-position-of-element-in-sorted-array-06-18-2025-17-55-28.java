class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lowerbound = n;
        int upperbound = n;

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
        
        if(lowerbound == n || nums[lowerbound] != target) return new int[]{-1, -1};
        else return new int[]{lowerbound, upperbound - 1};
    }
}