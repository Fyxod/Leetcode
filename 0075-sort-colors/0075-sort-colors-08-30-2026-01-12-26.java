class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        int ind = 0;

        while(ind <= j){
            if(nums[ind] == 0){
                nums[ind] = nums[i];
                nums[i++] = 0;
                ind++;
            }
            else if(nums[ind] == 2){
                nums[ind] = nums[j];
                nums[j--] = 2;
            }
            else ind++;
        }
    }
}