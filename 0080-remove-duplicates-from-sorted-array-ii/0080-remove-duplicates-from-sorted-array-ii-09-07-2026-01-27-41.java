class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int curr = Integer.MAX_VALUE;
        int cnt = 1;

        int j = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]){
                cnt++; 
                if(cnt <= 2) nums[j++] = nums[i];
            }
            else{
                cnt = 1;
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}