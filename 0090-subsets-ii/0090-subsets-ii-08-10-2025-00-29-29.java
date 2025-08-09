class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, list, new ArrayList<>(), 0);
        return new ArrayList<>(list);
    }
    void helper(int nums[], List<List<Integer>> ans, List<Integer> curr, int start){
        ans.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            helper(nums, ans, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}