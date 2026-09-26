class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        while(i < n && nums[i] <= 0){
            int j = i + 1, k = n - 1;
            int target = -nums[i];
            while(j < k){
                int sum = nums[j] + nums[k];
                if(sum < target) j++;
                else if(sum > target) k--;
                else{
                    List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    ans.add(temp);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;
                }
            }
            i++;
            while(i < n && nums[i] == nums[i - 1]) i++;
        }

        return ans;
    }
}