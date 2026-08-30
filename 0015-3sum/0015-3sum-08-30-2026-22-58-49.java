class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
       int n = nums.length;
       List<List<Integer>> ans = new ArrayList<>();

       int i = 0;
       while(i < n && nums[i] <= 0){
            if(i == n) break;
            int target = -nums[i];
            int left = i + 1;
            int right = n - 1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left <= right && nums[left] == nums[left - 1]) left++;
                    while(left <= right && nums[right] == nums[right + 1]) right--;
                }
                else if(nums[left] + nums[right] < target) left++;
                else right--;
            }
            i++;
            while(i < n && nums[i] == nums[i - 1]) i++;
       }
       return ans;
    }
}