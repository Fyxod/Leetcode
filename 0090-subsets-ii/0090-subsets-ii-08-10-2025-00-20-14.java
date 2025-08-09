class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(nums, list, new ArrayList<>(), 0, used);
        return new ArrayList<>(list);
    }
    void helper(int nums[], Set<List<Integer>> ans, List<Integer> curr, int start, boolean[] used){
        if(start == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            // used[i] = true;
            curr.add(nums[i]);
            helper(nums, ans, curr, i + 1, used);
            curr.remove(curr.size() - 1);
            // used[i] = false;
            helper(nums, ans, curr, i + 1, used);
        }
    }
}