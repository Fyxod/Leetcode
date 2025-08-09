class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        helper(nums, list, new ArrayList<>(), 0);
        return new ArrayList<>(list);
    }
    void helper(int nums[], Set<List<Integer>> ans, List<Integer> curr, int start){
        if(start == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            helper(nums, ans, curr, i + 1);
            curr.remove(curr.size() - 1);
            helper(nums, ans, curr, i + 1);
        }
    }
}