//dumb solution
class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        int l = nums.length;
        for(int i = 0; i < l; i++){
            int res = nums[i] % 3;
            if(res == 0)
            continue;
            count++;
            if(res == 2)
            nums[i]++;
            else
            nums[i]--;
        }
        return count;
    }
}
