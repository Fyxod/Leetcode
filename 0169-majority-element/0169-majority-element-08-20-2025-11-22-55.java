class Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int count = 0;
        for(int a : nums){
            if(count == 0) curr = a;
            if(a == curr) count++;
            else count--;
        }
        return curr;
    }
}