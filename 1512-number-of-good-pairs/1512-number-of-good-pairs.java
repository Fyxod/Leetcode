class Solution {
    public int numIdenticalPairs(int[] nums) {
        //Brute force
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] == nums[j])
                    count++;
            }
        }
        System.out.println(count);
        return count;
    }
}