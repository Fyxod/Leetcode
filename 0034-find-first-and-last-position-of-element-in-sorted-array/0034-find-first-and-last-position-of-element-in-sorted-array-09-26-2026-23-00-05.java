class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;

        int lower = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                lower = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        if(lower == -1 || nums[lower] != target) return new int[]{-1, -1};
        left = 0; right = n - 1;
        int higher = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                higher = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }

        return new int[]{lower, higher};
    }
}