class Solution {
    public boolean check(int[] nums) {
        int size = nums.length;
        if(size == 1) return true;
        
        int i  = 0;
        while(i < size - 1){
            if(nums[i + 1] < nums[i]){
                i++;
                break;
            }
            i++;
        }

        if(nums[i] > nums[i - 1] && i == size  - 1) return true;
        if(nums[size - 1] > nums[0]) return false;

        while(i < size - 1){
            if(nums[i + 1] < nums[i]) return false;
            i++;
        }

        return true;
    }
}
