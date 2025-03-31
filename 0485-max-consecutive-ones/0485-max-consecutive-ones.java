class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;

        for(int a: nums){
            if(a != 1){
                current = 0;
                continue;
            }
            current++;
            max = Math.max(current, max);
        }
        return max;
    }
}